package Bai1.connection;

public class HardwareConnection {
    private static HardwareConnection instance;

    private HardwareConnection() {}

    public static HardwareConnection getInstance() {
        if (instance == null) {
            instance = new HardwareConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Đã kết nối phần cứng (Singleton).");
    }

    public void disconnect() {
        System.out.println("Đã ngắt kết nối.");
    }
}
