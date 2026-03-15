package Bai3;

public class Ticket {

    private String ticketId;
    private boolean isSold;

    public Ticket(String id) {
        ticketId = id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }
}
