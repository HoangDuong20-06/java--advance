package Bai5;

public class Ticket {

    private String ticketId;

    private boolean isSold;
    private boolean isHeld;
    private boolean isVIP;

    private long holdExpireTime;

    public Ticket(String id){
        ticketId=id;
    }

    public String getTicketId(){
        return ticketId;
    }

    public boolean isSold(){
        return isSold;
    }

    public void setSold(boolean sold){
        isSold=sold;
    }

    public boolean isHeld(){
        return isHeld;
    }

    public void setHeld(boolean held){
        isHeld=held;
    }

    public long getHoldExpireTime(){
        return holdExpireTime;
    }

    public void setHoldExpireTime(long t){
        holdExpireTime=t;
    }

    public boolean isVIP(){
        return isVIP;
    }

    public void setVIP(boolean vip){
        isVIP=vip;
    }
}
