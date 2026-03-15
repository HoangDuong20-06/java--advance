package Bai6;

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

    public synchronized Ticket sellTicket(){

        for(Ticket t:tickets){

            if(!t.isSold()){

                t.setSold(true);
                return t;
            }
        }

        return null;
    }

    public int remaining(){

        int c=0;

        for(Ticket t:tickets)
            if(!t.isSold())
                c++;

        return c;
    }
}
