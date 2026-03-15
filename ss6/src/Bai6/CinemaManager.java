package Bai6;

import java.util.*;

public class CinemaManager {

    private TicketPool roomA;
    private TicketPool roomB;

    public CinemaManager(){

        roomA=new TicketPool("A",10);
        roomB=new TicketPool("B",10);
    }

    public void start(){

        BookingCounter c1=
                new BookingCounter("Counter1",roomA);

        BookingCounter c2=
                new BookingCounter("Counter2",roomB);

        new Thread(c1).start();
        new Thread(c2).start();

        new Thread(new DeadlockDetector()).start();
    }

    public void showStats(){

        System.out.println("Remaining A "+roomA.remaining());
        System.out.println("Remaining B "+roomB.remaining());
    }
}