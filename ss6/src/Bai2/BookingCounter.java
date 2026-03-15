package Bai2;

public class BookingCounter implements Runnable{

    private String name;
    private TicketPool roomA;
    private TicketPool roomB;

    public BookingCounter(String name,TicketPool a,TicketPool b){

        this.name=name;
        roomA=a;
        roomB=b;
    }

    @Override
    public void run(){

        while(true){

            Ticket t=roomA.sellTicket();

            if(t==null)
                t=roomB.sellTicket();

            if(t==null)
                break;

            System.out.println(name+" sold "+t.getTicketId());

            try{
                Thread.sleep(200);
            }catch(Exception e){}
        }
    }
}