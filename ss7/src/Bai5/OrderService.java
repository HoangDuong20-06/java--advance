package Bai5;

public class OrderService {
    private OrderRepository repository;
    private NotificationService notification;
    private InvoiceGenerator invoiceGenerator;
    public OrderService(OrderRepository repository, NotificationService notification, InvoiceGenerator invoiceGenerator) {
        this.repository = repository;
        this.notification = notification;
        this.invoiceGenerator = invoiceGenerator;
    }
    public void processOrder(Order order, DiscountStrategy discount, PaymentMethod payment) {
        double total = order.getTotal();
        double finalAmount = discount.apply(total);
        payment.pay(finalAmount);
        repository.save(order);
        invoiceGenerator.generate(order, total, finalAmount);
        notification.send("Đơn hàng " + order.getId() + " đã tạo");
    }
}