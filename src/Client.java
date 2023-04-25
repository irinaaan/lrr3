public class Client {
    private int idClients;
    private String name;
    private String surname;
    private int phonenumber;
    private String address;

    public Client(int idClients, String name, String surname, int phonenumber, String address) {
        this.idClients = idClients;
        this.name = name;
        this.surname = surname;
        this.phonenumber = phonenumber;
        this.address = address;
    }

    public Client() {
    }

    public int getIdClients() {
        return idClients;
    }

    public void setIdClients(int idClient) {
        this.idClients = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}