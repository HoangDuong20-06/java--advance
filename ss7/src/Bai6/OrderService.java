package Bai6;

public class OrderService {
    public void processOrder(SalesChannel channel, double amount) {
        DiscountStrategy discount = channel.createDiscount();
        PaymentMethod payment = channel.createPayment();
        NotificationService notification = channel.createNotification();
        double finalAmount = discount.applyDiscount(amount);
        payment.pay(finalAmount);
        notification.send("Đơn hàng thành công");
    }
}
