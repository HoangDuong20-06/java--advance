package Bai5.observer;

public class AirConditioner implements Observer {
    @Override
    public void update(int temp) {
        System.out.println("Điều hòa: Nhiệt độ = " + temp);
    }
}
