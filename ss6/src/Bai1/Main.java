package Bai1;

public class Main {

    public static void main(String[] args) throws Exception {

        TicketPool roomA = new TicketPool("A", 10);
        TicketPool roomB = new TicketPool("B", 10);

        BookingCounter c1 = new BookingCounter("Counter 1", roomA, roomB);
        BookingCounter c2 = new BookingCounter("Counter 2", roomA, roomB);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("\n===== RESULT =====");

        System.out.println("Counter1 sold: " + c1.getSoldCount());
        System.out.println("Counter2 sold: " + c2.getSoldCount());

        System.out.println("Remaining A: " + roomA.remaining());
        System.out.println("Remaining B: " + roomB.remaining());
    }
}
