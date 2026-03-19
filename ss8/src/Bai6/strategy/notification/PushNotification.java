package Bai6.strategy.notification;

public class PushNotification implements NotificationService {
    public void notifyUser(String message) {
        System.out.println("Push: " + message);
    }
}
