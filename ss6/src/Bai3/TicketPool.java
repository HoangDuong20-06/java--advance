package Bai3;

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

        while (remaining() == 0) {

            try {
                System.out.println("Hết vé phòng " + roomName + ", đang chờ...");
                wait();
            } catch (InterruptedException e) {}
        }

        for (Ticket t : tickets) {

            if (!t.isSold()) {
                t.setSold(true);
                return t;
            }
        }

        return null;
    }

    public synchronized void addTickets(int count) {

        int start = tickets.size() + 1;

        for (int i = 0; i < count; i++) {

            String id = roomName + "-" + String.format("%03d", start + i);
            tickets.add(new Ticket(id));
        }

        System.out.println("Nhà cung cấp thêm " + count + " vé phòng " + roomName);

        notifyAll();
    }

    public int remaining() {

        int c = 0;

        for (Ticket t : tickets)
            if (!t.isSold())
                c++;

        return c;
    }
}