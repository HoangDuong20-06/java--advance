package Bai5.observer;

public class Fan implements Observer {
    @Override
    public void update(int temp) {
        if (temp > 30) {
            System.out.println("Quạt: Nhiệt độ cao, chạy mạnh");
        } else {
            System.out.println("Quạt: Chạy tốc độ thấp");
        }
    }
}