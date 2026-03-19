package Bai3.command;

import Bai3.device.AirConditioner;

public class ACSetTempCommand implements Command {
    private AirConditioner ac;
    private int newTemp;
    private int prevTemp;

    public ACSetTempCommand(AirConditioner ac, int temp) {
        this.ac = ac;
        this.newTemp = temp;
    }

    public void execute() {
        prevTemp = ac.getTemp();
        ac.setTemp(newTemp);
    }

    public void undo() {
        ac.setTemp(prevTemp);
    }
}
