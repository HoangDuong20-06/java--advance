package Bai5;

import Bai5.command.SleepModeCommand;
import Bai5.device.Light;
import Bai5.observer.AirConditioner;
import Bai5.observer.Fan;
import Bai5.observer.TemperatureSensor;

public class Main {
    public static void main(String[] args) {

        Light light = new Light();
        TemperatureSensor sensor = new TemperatureSensor();

        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        sensor.attach(fan);
        sensor.attach(ac);

        SleepModeCommand sleepMode = new SleepModeCommand(light, sensor);

        System.out.println("=== Kích hoạt chế độ ngủ ===");
        sleepMode.execute();

        System.out.println("\n=== Nhiệt độ tăng lên 32 ===");
        sensor.setTemperature(32);
    }
}
