package Bai6;

public class PushNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Gửi push notification: " + message);
    }
}
