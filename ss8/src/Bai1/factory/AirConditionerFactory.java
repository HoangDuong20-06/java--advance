package Bai1.factory;
import Bai1.device.AirConditioner;
import Bai1.device.Device;

public class AirConditionerFactory implements DeviceFactory {
    @Override
    public Device createDevice() {
        System.out.println("AirConditionerFactory: Tạo điều hòa mới.");
        return new AirConditioner();
    }
}
