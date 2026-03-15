package Bai5;

public class Main {

    public static void main(String[] args){

        TicketPool roomA=new TicketPool("A",10);

        BookingCounter c1=new BookingCounter("Counter1",roomA);
        BookingCounter c2=new BookingCounter("Counter2",roomA);

        TimeoutManager tm=new TimeoutManager(roomA);

        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(tm).start();
    }
}
