package Bai6;

public abstract class SalesChannel {
    public abstract DiscountStrategy createDiscount();
    public abstract PaymentMethod createPayment();
    public abstract NotificationService createNotification();
}
