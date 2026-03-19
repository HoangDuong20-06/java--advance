package Bai1;
import Bai1.connection.HardwareConnection;
import Bai1.device.Device;
import Bai1.factory.AirConditionerFactory;
import Bai1.factory.DeviceFactory;
import Bai1.factory.FanFactory;
import Bai1.factory.LightFactory;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Device> devices = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị");
            System.out.println("3. Bật thiết bị");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    HardwareConnection conn = HardwareConnection.getInstance();
                    conn.connect();
                    break;

                case 2:
                    System.out.println("1. Đèn  2. Quạt  3. Điều hòa");
                    int type = sc.nextInt();

                    DeviceFactory factory = null;

                    switch (type) {
                        case 1:
                            factory = new LightFactory();
                            break;
                        case 2:
                            factory = new FanFactory();
                            break;
                        case 3:
                            factory = new AirConditionerFactory();
                            break;
                        default:
                            System.out.println("Sai loại!");
                            continue;
                    }

                    Device device = factory.createDevice();
                    devices.add(device);
                    break;

                case 3:
                    if (devices.isEmpty()) {
                        System.out.println("Chưa có thiết bị!");
                        break;
                    }

                    System.out.println("Chọn thiết bị (index): ");
                    for (int i = 0; i < devices.size(); i++) {
                        System.out.println(i + ". " + devices.get(i).getClass().getSimpleName());
                    }

                    int index = sc.nextInt();
                    if (index >= 0 && index < devices.size()) {
                        devices.get(index).turnOn();
                    } else {
                        System.out.println("Sai index!");
                    }
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Sai lựa chọn!");
            }
        }
    }
}