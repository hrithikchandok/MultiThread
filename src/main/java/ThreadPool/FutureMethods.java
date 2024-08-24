package ThreadPool;

import java.util.concurrent.*;
import java.util.concurrent.Future;

public class FutureMethods {
    public static void main(String[] args) {

        ThreadPoolExecutor ex=new ThreadPoolExecutor(1,1,1, TimeUnit.MINUTES,new ArrayBlockingQueue<>(2),new Main.CustomFactory(),new ThreadPoolExecutor.DiscardPolicy());

        Future<?> submit = ex.submit(() ->
        {
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Is it complete ?"+submit.isDone());
        try {
           submit.get(2,TimeUnit.MILLISECONDS);
            System.out.println("Getting the result");
       }
        catch (TimeoutException e)
        {
            System.out.println("Time out exception occurs "+e.toString());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        try {
            submit.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        finally {
            ex.shutdown();
        }

        System.out.println("is it done->"+submit.isDone());
        System.out.println("it is canceled->"+submit.isCancelled());



    }
}
