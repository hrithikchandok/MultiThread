package ThreadPool;

import java.util.concurrent.*;
import java.util.concurrent.Future;

public class Main {


//    THread pool -> collectioj of thread which are avaible to complete the submitted task

//    Tasks are coming get stired  in the queue and then threead are assigned from the thread pool


//    Advantege of Thread pool
//            We dont have to create the thread
//            Thread management is less
//            Scalable solution
//            reuse of the thread
//            memory consumtion less
//            performance is increased


    public static  void main(String[] args) {
        ThreadPoolExecutor ex = new ThreadPoolExecutor(2, 3, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),new CustomFactory(), new CustomRejectedHandlere());
//            ex.allowCoreThreadTimeOut(true); // only then keepalive will be used

        // Submit a task to the thread pool
        Future<?> statusOfThread = ex.submit(() -> System.out.println("Thread is processed: " + Thread.currentThread().getName()));

        // Check if the task is done
        try {
            System.out.println("Task done: " + statusOfThread.isDone());
            // Wait for the task to complete and get the result
            statusOfThread.get();
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Task execution failed: " + e.getMessage());
        }

        // Shut down the thread pool
        ex.shutdown();
    }

    public static  class  CustomFactory implements  ThreadFactory
    {

        @Override
        public Thread newThread(Runnable r) {
               Thread th =new Thread(r);
               th.setDaemon(false);
               th.setPriority(5);
            return th;
        }
    }

    static class CustomRejectedHandlere implements  RejectedExecutionHandler
    {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task rejected"+r.toString());
        }
    }

}
