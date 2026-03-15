package Bai6;

public class BookingCounter implements Runnable{

    private String name;

    private TicketPool pool;

    public BookingCounter(String name,TicketPool pool){

        this.name=name;
        this.pool=pool;
    }

    @Override
    public void run(){

        while(true){

            Ticket t=pool.sellTicket();

            if(t==null)
                break;

            System.out.println(
                    name+" sold "+t.getId()
            );

            try{
                Thread.sleep(200);
            }catch(Exception e){}
        }
    }
}
