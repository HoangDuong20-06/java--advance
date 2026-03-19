package Bai1.factory;
import Bai1.device.Device;
import Bai1.device.Light;

public class LightFactory implements DeviceFactory {
    @Override
    public Device createDevice() {
        System.out.println("LightFactory: Tạo đèn mới.");
        return new Light();
    }
}
