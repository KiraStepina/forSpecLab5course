package bussiness;

/**
 * Created by IntelliJ IDEA.
 * User: HomeUser
 * Date: 29.9.12
 * Time: 13.17
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    private String name;
    private String address;
    private String telephone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String toString() {
        String result = String.format("<client><name>%1$s</name><address>%2$s</address><telephone>%3$s</telephone></client>", name, address, telephone);
        return result;
    }
}
