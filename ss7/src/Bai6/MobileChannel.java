package Bai6;

public class MobileChannel extends SalesChannel {
    @Override
    public DiscountStrategy createDiscount() {
        return new MobileDiscount();
    }
    @Override
    public PaymentMethod createPayment() {
        return new MoMoPayment();
    }
    @Override
    public NotificationService createNotification() {
        return new PushNotification();
    }
}
