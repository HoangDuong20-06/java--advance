package Bai3;

public class BookingCounter implements Runnable {

    private String name;
    private TicketPool pool;

    public BookingCounter(String name, TicketPool pool) {

        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run() {

        while (true) {

            Ticket t = pool.sellTicket();

            if (t == null)
                break;

            System.out.println(name + " bán " + t.getTicketId());

            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}