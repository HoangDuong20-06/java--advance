package Bai4;

import java.util.*;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String room, int count) {

        roomName = room;

        for (int i = 1; i <= count; i++) {

            String id = room + "-" + String.format("%03d", i);
            tickets.add(new Ticket(id));
        }
    }

    public synchronized Ticket sellTicket() {

        for (Ticket t : tickets) {

            if (!t.isSold()) {
                t.setSold(true);
                return t;
            }
        }

        return null;
    }

    public Ticket[] sellCombo(TicketPool other) {

        TicketPool first = this;
        TicketPool second = other;

        if (this.hashCode() > other.hashCode()) {
            first = other;
            second = this;
        }

        synchronized (first) {

            synchronized (second) {

                Ticket t1 = this.sellTicket();
                Ticket t2 = other.sellTicket();

                if (t1 == null || t2 == null) {

                    if (t1 != null) t1.setSold(false);
                    if (t2 != null) t2.setSold(false);

                    return null;
                }

                return new Ticket[]{t1, t2};
            }
        }
    }
}
