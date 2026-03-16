package Bai5;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();
    public Order(String id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }
    public void addItem(Product p, int qty) {
        items.add(new OrderItem(p, qty));
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotal();
        }
        return total;
    }
    public String getId() {
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }
}