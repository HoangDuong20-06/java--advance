package Bai3.remote;

import Bai3.command.Command;

import java.util.Stack;

public class UndoManager {
    private Stack<Command> history = new Stack<>();

    public void push(Command cmd) {
        history.push(cmd);
    }

    public void undo() {
        if (!history.isEmpty()) {
            history.pop().undo();
        }
    }
}
