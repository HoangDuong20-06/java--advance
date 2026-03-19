package Bai5.observer;
import java.util.ArrayList;
import java.util.List;
public class TemperatureSensor {

    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void attach(Observer o) {
        observers.add(o);
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("Cảm biến: Nhiệt độ = " + temp);
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }
}
