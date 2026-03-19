package Bai6.service;

import Bai6.factory.SalesChannelFactory;
import Bai6.strategy.discount.DiscountStrategy;
import Bai6.strategy.notification.NotificationService;
import Bai6.strategy.payment.PaymentMethod;

public class OrderProcessor {
    private DiscountStrategy discount;
    private PaymentMethod payment;
    private NotificationService notification;

    public OrderProcessor(SalesChannelFactory factory) {
        this.discount = factory.createDiscountStrategy();
        this.payment = factory.createPaymentMethod();
        this.notification = factory.createNotificationService();
    }

    public void processOrder(double amount) {
        double finalAmount = discount.applyDiscount(amount);

        System.out.println("Sau giảm: " + finalAmount);

        payment.pay(finalAmount);
        notification.notifyUser("Đơn hàng thành công!");
    }
}
