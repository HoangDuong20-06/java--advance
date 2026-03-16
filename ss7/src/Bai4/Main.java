package Bai4;

public class Main {

    public static void main(String[] args) {

        OrderRepository repo1 = new FileOrderRepository();
        NotificationService noti1 = new EmailService();

        OrderService orderService1 = new OrderService(repo1, noti1);

        Order order1 = new Order("ORD001");

        orderService1.createOrder(order1, "user@email.com");


        System.out.println("-----");
        OrderRepository repo2 = new DatabaseOrderRepository();
        NotificationService noti2 = new SMSNotification();

        OrderService orderService2 = new OrderService(repo2, noti2);

        Order order2 = new Order("ORD002");

        orderService2.createOrder(order2, "0900000000");
    }
}