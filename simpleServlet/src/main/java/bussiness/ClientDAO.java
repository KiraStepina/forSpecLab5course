package bussiness;

import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: HomeUser
 * Date: 1.10.12
 * Time: 12.58
 * To change this template use File | Settings | File Templates.
 */
public class ClientDAO {
    private static ClientList clientList = new ClientList();
    public List<Client> find(int left, int right){
        List<Client> list = clientList.getListOfClient();
        if (left<0 && right > 0){
            left = 0;
        }
        if (left>=0 && left < list.size()){
            if (right > list.size()){
                right = list.size();
            }
            list = list.subList(left,right);
        }
        else list = Collections.emptyList();
        return list;
    }
    public void add(Client client){
        clientList.addClient(client);
    }
    public int getSize(){
        return clientList.getListOfClient().size();
    }
}
