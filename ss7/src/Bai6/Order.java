package Bai6;

import Bai1.Customer;
import Bai1.Product;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private String orderId;
    private Bai1.Customer customer;

    private Map<Bai1.Product, Integer> products = new HashMap<>();

    public Order(String orderId, Bai1.Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public void addProduct(Bai1.Product product, int quantity) {
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
