public class Order {
    private int idOrders;
    private String productname;
    private String client;
    private String date;
    private double sum;

    public Order(int idOrders, String productname, String client, String date, double sum) {
        this.idOrders = idOrders;
        this.productname = productname;
        this.client = client;
        this.date = date;
        this.sum = sum;
    }

    public Order() {
    }

    public int getIdOrders() {
        return idOrders;
    }

    public void setIdOrders(int idOrder) {
        this.idOrders = idOrder;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String name) {
        this.productname = productname;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}