package bussiness;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: HomeUser
 * Date: 29.9.12
 * Time: 13.51
 * To change this template use File | Settings | File Templates.
 */
public class ClientList {
    private List<Client> listOfClient;
    public ClientList (){
        listOfClient = new ArrayList<Client>();
    }

    public List<Client> getListOfClient() {
        return listOfClient;
    }

    public void addClient(Client client) {
        listOfClient.add(client);
    }
}
