package Bai1;
import java.util.HashMap;
import java.util.Map;

public class Order {

    private String orderId;
    private Customer customer;

    private Map<Product, Integer> products = new HashMap<>();

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }
}
