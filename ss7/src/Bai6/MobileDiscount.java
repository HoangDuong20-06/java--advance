package Bai6;

public class MobileDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        System.out.println("Áp dụng giảm giá 15% cho lần đầu");
        return amount * 0.85;
    }
}