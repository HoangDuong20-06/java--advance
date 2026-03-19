package Bai4.facade;

import Bai4.device.AirConditioner;
import Bai4.device.Fan;
import Bai4.device.Light;

public class SmartHomeFacade {
    private Light light = new Light();
    private Fan fan = new Fan();
    private AirConditioner ac = new AirConditioner();

    public void leaveHome() {
        light.off();
        fan.off();
        ac.off();
    }

    public void sleepMode() {
        light.off();
        ac.setTemp(28);
        fan.lowSpeed();
    }
}
