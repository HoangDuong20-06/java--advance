package Bai6.strategy.discount;

public class WebsiteDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.9;
    }
}
