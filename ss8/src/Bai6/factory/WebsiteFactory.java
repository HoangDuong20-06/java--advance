package Bai6.factory;

import Bai6.strategy.discount.DiscountStrategy;
import Bai6.strategy.discount.WebsiteDiscount;
import Bai6.strategy.notification.EmailNotification;
import Bai6.strategy.notification.NotificationService;
import Bai6.strategy.payment.CreditCardPayment;
import Bai6.strategy.payment.PaymentMethod;

public class WebsiteFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscountStrategy() {
        return new WebsiteDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }

    public NotificationService createNotificationService() {
        return new EmailNotification();
    }
}
