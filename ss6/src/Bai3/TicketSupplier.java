package Bai3;

public class TicketSupplier implements Runnable {

    private TicketPool pool;

    public TicketSupplier(TicketPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(5000);
            } catch (Exception e) {}

            pool.addTickets(3);
        }
    }
}