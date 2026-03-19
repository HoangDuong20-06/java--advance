package Bai6.factory;

import Bai6.strategy.discount.DiscountStrategy;
import Bai6.strategy.discount.POSDiscount;
import Bai6.strategy.notification.NotificationService;
import Bai6.strategy.notification.PrintReceipt;
import Bai6.strategy.payment.CODPayment;
import Bai6.strategy.payment.PaymentMethod;

public class POSFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscountStrategy() {
        return new POSDiscount();
    }

    public PaymentMethod createPaymentMethod() {
        return new CODPayment();
    }

    public NotificationService createNotificationService() {
        return new PrintReceipt();
    }
}
