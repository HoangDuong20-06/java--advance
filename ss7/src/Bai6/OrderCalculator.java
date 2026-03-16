package Bai6;

import Bai1.Order;
import Bai1.Product;

import java.util.Map;

public class OrderCalculator {

    public double calculateTotal(Order order) {

        double total = 0;

        for (Map.Entry<Bai1.Product, Integer> entry : order.getProducts().entrySet()) {

            Product p = entry.getKey();
            int quantity = entry.getValue();

            total += p.getPrice() * quantity;
        }

        return total;
    }
}
