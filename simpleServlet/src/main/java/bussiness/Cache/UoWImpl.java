package bussiness.Cache;

import bussiness.Client;
import bussiness.ClientDAO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: HomeUser
 * Date: 24.10.12
 * Time: 14.37
 * To change this template use File | Settings | File Templates.
 */
public class UoWImpl implements UoW {
    private final Map<String, Client> modify;
    private final Map<String, Client> notModify;
    private final ClientDAO clientDAO;

    public UoWImpl() {
        modify = new HashMap<String, Client>();
        notModify = new HashMap<String, Client>();
        clientDAO = new ClientDAO();
    }

    @Override
    public Client create(Client client) {
        client.setId(new Date().getTime() + "");
        modify.put(client.getId(), client);
        return client;
    }

    @Override
    public Client retrieve(String id) {
        if (!modify.containsKey(id)) {
            modify.put(id, clientDAO.getClient(id));
            notModify.put(id, clientDAO.getClient(id));
        }
        return modify.get(id);
    }

    @Override
    public Client update(Client client) {
        modify.put(client.getId(), client);
        return client;
    }

    @Override
    public void delete(Client client) {
        modify.remove(client.getId());
    }

    @Override
    public void commit() {
        for (String clientId : modify.keySet()) {
            if (notModify.get(clientId) == null)
                clientDAO.add(modify.get(clientId));
            if (!modify.get(clientId).equals(notModify.get(clientId)))
                clientDAO.updateClient(modify.get(clientId));
        }
        for (String clientId : notModify.keySet()) {
            if (modify.get(clientId) == null)
                clientDAO.deleteClient(notModify.get(clientId));
        }
        modify.clear();
        notModify.clear();
    }
}
