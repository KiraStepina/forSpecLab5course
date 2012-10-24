package bussiness.Cache;

import bussiness.Client;

/**
 * Created by IntelliJ IDEA.
 * User: HomeUser
 * Date: 24.10.12
 * Time: 14.31
 * To change this template use File | Settings | File Templates.
 */
public interface UoW {
    public Client create(Client client);

    public Client retrieve(String id);

    public Client update(Client client);

    public void delete(Client client);

    public void commit();
}
