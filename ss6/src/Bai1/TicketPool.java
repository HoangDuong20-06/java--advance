package Bai1;

import java.util.*;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int count) {
        this.roomName = roomName;

        for (int i = 1; i <= count; i++) {
            String id = roomName + "-" + String.format("%03d", i);
            tickets.add(new Ticket(id, roomName));
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

    public int remaining() {
        int c = 0;
        for (Ticket t : tickets) {
            if (!t.isSold()) c++;
        }
        return c;
    }
}
