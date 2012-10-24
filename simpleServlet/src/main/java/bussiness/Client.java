package bussiness;

/**
 * @author HomeUser
 *         Date: 29.9.12
 *         Time: 13.17
 */
public class Client {

    private String id;
    private String name;
    private String address;
    private String telephone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        return String.format("<client><name>%1$s</name><address>%2$s</address><telephone>%3$s</telephone></client>", name, address, telephone);
    }
}
