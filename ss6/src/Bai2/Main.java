package Bai2;

public class Main {

    public static void main(String[] args){

        TicketPool roomA=new TicketPool("A",5);
        TicketPool roomB=new TicketPool("B",5);

        BookingCounter c1=new BookingCounter("Counter1",roomA,roomB);
        BookingCounter c2=new BookingCounter("Counter2",roomA,roomB);

        TicketSupplier supplier=
                new TicketSupplier(roomA,roomB,3,3000,3);

        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(supplier).start();
    }
}