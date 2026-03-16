package Bai6;
public class EmailNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Gửi email xác nhận: " + message);
    }
}
