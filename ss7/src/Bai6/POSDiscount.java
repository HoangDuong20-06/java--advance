package Bai6;

public class POSDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        System.out.println("Giảm 5% cho thành viên tại cửa hàng");
        return amount * 0.95;
    }
}
