package Bai6.strategy.discount;

public class MobileDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.85;
    }
}
