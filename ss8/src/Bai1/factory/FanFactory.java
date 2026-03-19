package Bai1.factory;
import Bai1.device.Device;
import Bai1.device.Fan;

public class FanFactory implements DeviceFactory {
    @Override
    public Device createDevice() {
        System.out.println("FanFactory: Tạo quạt mới.");
        return new Fan();
    }
}
