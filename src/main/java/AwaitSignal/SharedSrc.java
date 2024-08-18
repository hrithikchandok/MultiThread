package AwaitSignal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedSrc {


    private Boolean isAvailable=false;
    ReentrantLock lock=new ReentrantLock();
    Condition condition= lock.newCondition();


//    Consumer is read
//    producer is write
    public void consumer()
    {
        try
        {
            System.out.println("Consumer is Trying");
            lock.lock();

            if(!isAvailable)
            {
                System.out.println("Consumer thread is Waiting ");

                    condition.await();

            }
            isAvailable=false;
            condition.signal();

        }
         catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Lock release by "+Thread.currentThread().getName());
            lock.unlock();
        }


    }

    public void producer()
    {
        try
        {
            System.out.println("Producer is trying");
            lock.lock();

            if(isAvailable)
            {
                System.out.println("Procucer have to wait");
                condition.await();
            }
            isAvailable=false;
            condition.signal();
        }
        catch (Exception e)
        {
            // handle the exception
        }
        finally {
            System.out.println("Lock release by "+Thread.currentThread().getName());
            lock.unlock();
        }
    }

}
