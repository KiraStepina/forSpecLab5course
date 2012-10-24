package bussiness;

import java.util.Collections;
import java.util.List;

/**
 * @author HomeUser
 *         Date: 1.10.12
 *         Time: 12.58
 */
public class ClientDAO {
    private static final ClientList clientList = new ClientList();

    public List<Client> find(int left, int right) {
        List<Client> list = clientList.getListOfClient();
        if (left < 0 && right > 0) {
            left = 0;
        }
        if (left >= 0 && left < list.size()) {
            if (right > list.size()) {
                right = list.size();
            }
            list = list.subList(left, right);
        } else list = Collections.emptyList();
        return list;
    }

    public void add(Client client) {
        clientList.addClient(client);
    }

    public int getSize() {
        return clientList.getListOfClient().size();
    }

    public Client getClient(String id) {
        return clientList.getClient(id);
    }

    public Client updateClient(Client client) {
        return clientList.updateClient(client);
    }

    public void deleteClient(Client client) {
        clientList.deleteClient(client);
    }
}
