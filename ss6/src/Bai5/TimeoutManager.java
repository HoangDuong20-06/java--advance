package Bai5;

public class TimeoutManager implements Runnable{

    private TicketPool pool;

    public TimeoutManager(TicketPool pool){

        this.pool=pool;
    }

    @Override
    public void run(){

        while(true){

            pool.releaseExpiredTickets();

            try{
                Thread.sleep(1000);
            }catch(Exception e){}
        }
    }
}
