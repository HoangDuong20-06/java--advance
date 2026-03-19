package Bai6.strategy.discount;

public class POSDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.95;
    }
}
