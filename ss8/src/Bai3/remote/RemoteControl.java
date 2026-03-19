package Bai3.remote;

import Bai3.command.Command;

public class RemoteControl {
    private Command slot;
    private UndoManager undoManager;

    public RemoteControl(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void pressButton() {
        slot.execute();
        undoManager.push(slot);
    }

    public void pressUndo() {
        undoManager.undo();
    }
}
