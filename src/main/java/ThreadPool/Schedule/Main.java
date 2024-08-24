package ThreadPool.Schedule;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        ScheduledThreadPoolExecutor ex=new ScheduledThreadPoolExecutor(1);
        ex.schedule(()-> System.out.println("printing the schedule task"),2, TimeUnit.SECONDS);

        ex.scheduleAtFixedRate(()-> System.out.println("Run in Intervals"),2,3,TimeUnit.SECONDS);

    }
}
