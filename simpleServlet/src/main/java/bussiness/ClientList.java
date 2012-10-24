package bussiness;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HomeUser
 *         Date: 29.9.12
 *         Time: 13.51
 */
class ClientList {
    private final List<Client> listOfClient;

    public ClientList() {
        listOfClient = new ArrayList<Client>();
    }

    public List<Client> getListOfClient() {
        return listOfClient;
    }

    public void addClient(Client client) {
        listOfClient.add(client);
    }

    public Client getClient(String id) {
        for (Client clientCounter : listOfClient) {
            if (clientCounter.getId().equals(id))
                return clientCounter;
        }
        return null;
    }

    public Client updateClient(Client client) {
        for (Client clientCounter : listOfClient) {
            if (clientCounter.getId().equals(client.getId())) {
                clientCounter.setId(client.getId());
                clientCounter.setName(client.getName());
                clientCounter.setAddress(client.getAddress());
                clientCounter.setTelephone(client.getTelephone());
                return clientCounter;
            }
        }
        return null;
    }

    public void deleteClient(Client client) {
        listOfClient.remove(client);
    }
}
