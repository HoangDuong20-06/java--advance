package Bai4.device;

public class AirConditioner {
    public void off() {
        System.out.println("FACADE: Tắt điều hòa");
    }

    public void setTemp(int t) {
        System.out.println("FACADE: Điều hòa set " + t + "°C");
    }
}
