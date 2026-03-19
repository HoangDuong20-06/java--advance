package Bai2.facade;

import Bai2.device.AirConditioner;
import Bai2.device.Fan;
import Bai2.device.Light;

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
