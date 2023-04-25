public class Product {
    private int idProducts;
    private String name;
    private double price;
    private String description;

    public Product(int idProducts, String name, double price, String description) {
        this.idProducts = idProducts;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }

    public int getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(int idProducts) {
        this.idProducts = idProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}