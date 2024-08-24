package ThreadPool.Executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) {
        ExecutorService ex= Executors.newFixedThreadPool(2);// exact threads
        ExecutorService ex1= Executors.newCachedThreadPool();// min=0 max=Integer.MAX_VALUE  blocking queue=0; thread alive =60s
        ExecutorService ex2= Executors.newSingleThreadExecutor();// only one thread unblocking queue

        ex.submit(()-> System.out.println());
    }

}
