package business;
import java.io.Serializable;

public class Product implements Serializable {
    private String code;
    private String name;
    private double price;

    public Product() {
        code = "";
        name = "";
        price = 0;
    }

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void  setCode(String code) { this.code = code; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
