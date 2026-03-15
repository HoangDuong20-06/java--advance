package Bai5;

import java.util.*;

public class TicketPool {

    private String roomName;

    private List<Ticket> tickets=new ArrayList<>();

    public TicketPool(String room,int count){

        roomName=room;

        for(int i=1;i<=count;i++){

            String id=room+"-"+String.format("%03d",i);
            tickets.add(new Ticket(id));
        }
    }

    public synchronized Ticket holdTicket(boolean vip){

        for(Ticket t:tickets){

            if(!t.isSold() && !t.isHeld()){

                t.setHeld(true);
                t.setVIP(vip);

                long expire=System.currentTimeMillis()+5000;

                t.setHoldExpireTime(expire);

                return t;
            }
        }

        return null;
    }

    public synchronized void sellHeldTicket(Ticket t){

        if(t!=null && t.isHeld()){

            t.setHeld(false);
            t.setSold(true);
        }
    }

    public synchronized void releaseExpiredTickets(){

        long now=System.currentTimeMillis();

        for(Ticket t:tickets){

            if(t.isHeld() && now>t.getHoldExpireTime()){

                t.setHeld(false);

                System.out.println(
                        "TimeoutManager: "+t.getTicketId()+" released"
                );
            }
        }
    }
}
