package Bai5;

public class SMSNotification implements NotificationService {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}
