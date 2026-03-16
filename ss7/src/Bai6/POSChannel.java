package Bai6;

public class POSChannel extends SalesChannel {
    @Override
    public DiscountStrategy createDiscount() {
        return new POSDiscount();
    }
    @Override
    public PaymentMethod createPayment() {
        return new POSPayment();
    }
    @Override
    public NotificationService createNotification() {
        return new POSNotification();
    }
}
