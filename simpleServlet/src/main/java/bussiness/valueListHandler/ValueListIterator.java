package bussiness.valueListHandler;

import bussiness.Client;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: HomeUser
 * Date: 1.10.12
 * Time: 12.09
 * To change this template use File | Settings | File Templates.
 */
public interface ValueListIterator {
    public int getSize();
    public List<Client> getPreviousElements(int count);
    public List<Client> getNextElements(int count);
    public List<Client> getFirstElement(int count);
    public List<Client> getLastElement(int count);
}
