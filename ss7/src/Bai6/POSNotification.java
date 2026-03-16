package Bai6;

public class POSNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("In hóa đơn giấy: " + message);
    }
}
