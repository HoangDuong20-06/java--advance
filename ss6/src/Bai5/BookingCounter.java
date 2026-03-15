package Bai5;

import java.util.Random;

public class BookingCounter implements Runnable{

    private String name;

    private TicketPool pool;

    private Random random=new Random();

    public BookingCounter(String name,TicketPool pool){

        this.name=name;
        this.pool=pool;
    }

    @Override
    public void run(){

        while(true){

            boolean vip=random.nextBoolean();

            Ticket t=pool.holdTicket(vip);

            if(t==null)
                break;

            System.out.println(
                    name+" holding "+t.getTicketId()
            );

            try{

                Thread.sleep(3000);

            }catch(Exception e){}

            pool.sellHeldTicket(t);

            System.out.println(
                    name+" sold "+t.getTicketId()
            );
        }
    }
}
