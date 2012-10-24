package bussiness.valueListHandler;

import bussiness.Client;
import bussiness.ClientDAO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: HomeUser
 * Date: 1.10.12
 * Time: 12.18
 * To change this template use File | Settings | File Templates.
 */
public class ValueListHandler implements ValueListIterator {
    private final ClientDAO clientDAO;
    private int left;

    public ValueListHandler() {
        left = 0;
        clientDAO = new ClientDAO();
    }

    @Override
    public int getSize() {
        return clientDAO.getSize();
    }

    @Override
    public List getPreviousElements(int count) {
        List<Client> list = clientDAO.find(this.left - count, this.left);
        left = this.left - count;
        return list;
    }

    @Override
    public List getNextElements(int count) {
        List<Client> list = clientDAO.find(this.left + count, this.left + 2 * count);
        left = this.left + count;
        return list;
    }

    @Override
    public List<Client> getFirstElement(int count) {
        List<Client> list;
        if (clientDAO.getSize() < count) {
            list = clientDAO.find(0, clientDAO.getSize());
        } else {
            list = clientDAO.find(0, count);
        }
        left = 0;
        return list;
    }

    @Override
    public List<Client> getLastElement(int count) {
        List<Client> list = clientDAO.find(this.getSize() - count, this.getSize());
        left = this.getSize() - count;
        return list;
    }

    public void add(Client client) {
        clientDAO.add(client);
    }
}
