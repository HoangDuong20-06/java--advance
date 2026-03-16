package Bai1;

import java.util.Map;

public class OrderCaculator {

    public double calculateTotal(Order order) {

        double total = 0;

        for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()) {

            Product p = entry.getKey();
            int quantity = entry.getValue();

            total += p.getPrice() * quantity;
        }

        return total;
    }
}
