package Bai4;

import Bai4.facade.SmartHomeFacade;
import Bai4.sensor.OldThermometer;
import Bai4.sensor.TemperatureSensor;
import Bai4.sensor.ThermometerAdapter;

public class Main {
    public static void main(String[] args) {
        OldThermometer old = new OldThermometer();
        TemperatureSensor sensor = new ThermometerAdapter(old);

        System.out.println("Nhiệt độ: " + sensor.getTemperatureCelsius() + "°C");

        SmartHomeFacade facade = new SmartHomeFacade();

        System.out.println("\nRời nhà:");
        facade.leaveHome();

        System.out.println("\nChế độ ngủ:");
        facade.sleepMode();
    }
}
