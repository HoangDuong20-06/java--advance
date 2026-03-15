package Bai6;

import java.lang.management.*;

public class DeadlockDetector implements Runnable{

    @Override
    public void run(){

        ThreadMXBean bean=
                ManagementFactory.getThreadMXBean();

        while(true){

            long[] ids=bean.findDeadlockedThreads();

            if(ids!=null){

                System.out.println("Deadlock detected!");
            }

            try{
                Thread.sleep(2000);
            }catch(Exception e){}
        }
    }
}
