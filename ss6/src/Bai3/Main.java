package Bai3;

public class Main {

    public static void main(String[] args) {

        TicketPool roomA = new TicketPool("A", 5);

        BookingCounter c1 = new BookingCounter("Quầy1", roomA);
        BookingCounter c2 = new BookingCounter("Quầy2", roomA);

        TicketSupplier supplier = new TicketSupplier(roomA);

        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(supplier).start();
    }
}
