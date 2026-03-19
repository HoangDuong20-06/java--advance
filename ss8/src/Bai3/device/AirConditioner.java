package Bai3.device;

public class AirConditioner {
    private int temp = 25;

    public void setTemp(int t) {
        temp = t;
        System.out.println("Điều hòa: Nhiệt độ = " + t);
    }

    public int getTemp() {
        return temp;
    }
}
