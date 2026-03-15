package Bai1;

import java.util.Random;

public class BookingCounter implements Runnable {

    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;

    private int soldCount = 0;
    private Random random = new Random();

    public BookingCounter(String name, TicketPool a, TicketPool b) {
        counterName = name;
        roomA = a;
        roomB = b;
    }

    public int getSoldCount() {
        return soldCount;
    }

    @Override
    public void run() {

        while (true) {

            Ticket ticket;

            if (random.nextBoolean()) {
                ticket = roomA.sellTicket();
                if (ticket == null) ticket = roomB.sellTicket();
            } else {
                ticket = roomB.sellTicket();
                if (ticket == null) ticket = roomA.sellTicket();
            }

            if (ticket == null) break;

            soldCount++;

            System.out.println(counterName + " sold " + ticket.getTicketId());

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
    }
}