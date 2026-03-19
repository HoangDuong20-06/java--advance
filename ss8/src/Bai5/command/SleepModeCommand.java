package Bai5.command;

import Bai5.device.Light;
import Bai5.observer.TemperatureSensor;

public class SleepModeCommand implements Command {

    private Light light;
    private TemperatureSensor sensor;

    public SleepModeCommand(Light light, TemperatureSensor sensor) {
        this.light = light;
        this.sensor = sensor;
    }

    @Override
    public void execute() {
        System.out.println("SleepMode: Tắt đèn");
        light.off();

        System.out.println("SleepMode: Điều hòa set 28°C");
        sensor.setTemperature(28);

        System.out.println("SleepMode: Quạt tốc độ thấp");
    }
}
