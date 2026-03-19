package Bai6.factory;

import Bai6.strategy.discount.DiscountStrategy;
import Bai6.strategy.discount.MobileDiscount;
import Bai6.strategy.notification.NotificationService;
import Bai6.strategy.notification.PushNotification;
import Bai6.strategy.payment.MomoPayment;
import Bai6.strategy.payment.PaymentMethod;

public class MobileFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscountStrategy() {
        return new MobileDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new MomoPayment();
    }

    public NotificationService createNotificationService() {
        return new PushNotification();
    }
}
