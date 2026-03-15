package Bai4;

public class BookingCounter implements Runnable {

    private String name;

    private TicketPool roomA;
    private TicketPool roomB;

    public BookingCounter(String name, TicketPool a, TicketPool b) {

        this.name = name;
        roomA = a;
        roomB = b;
    }

    @Override
    public void run() {

        while (true) {

            Ticket[] combo = roomA.sellCombo(roomB);

            if (combo == null)
                break;

            System.out.println(name +
                    " bán combo "
                    + combo[0].getId()
                    + " + "
                    + combo[1].getId());

            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}
