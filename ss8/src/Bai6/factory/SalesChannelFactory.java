package Bai6.factory;

import Bai6.strategy.discount.DiscountStrategy;
import Bai6.strategy.notification.NotificationService;
import Bai6.strategy.payment.PaymentMethod;

public interface SalesChannelFactory {
    DiscountStrategy createDiscountStrategy();
    PaymentMethod createPaymentMethod();
    NotificationService createNotificationService();
}
