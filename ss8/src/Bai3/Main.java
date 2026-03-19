package Bai3;

import Bai3.command.ACSetTempCommand;
import Bai3.command.LightOffCommand;
import Bai3.command.LightOnCommand;
import Bai3.device.AirConditioner;
import Bai3.device.Light;
import Bai3.remote.RemoteControl;
import Bai3.remote.UndoManager;

public class Main {
    public static void main(String[] args) {

        Light light = new Light();
        AirConditioner ac = new AirConditioner();

        UndoManager undo = new UndoManager();
        RemoteControl remote = new RemoteControl(undo);

        remote.setCommand(new LightOnCommand(light));
        remote.pressButton();

        remote.setCommand(new LightOffCommand(light));
        remote.pressButton();

        remote.pressUndo();

        remote.setCommand(new ACSetTempCommand(ac, 26));
        remote.pressButton();

        remote.pressUndo();
    }
}
