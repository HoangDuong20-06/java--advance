package Bai6;

public class WebsiteChannel extends SalesChannel {
    @Override
    public DiscountStrategy createDiscount() {
        return new WebsiteDiscount();
    }
    @Override
    public PaymentMethod createPayment() {
        return new CreditCardPayment();
    }
    @Override
    public NotificationService createNotification() {
        return new EmailNotification();
    }
}