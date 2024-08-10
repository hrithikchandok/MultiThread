package FairnessLock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.*;
public class Fair {

    private final Lock lock=new ReentrantLock(true);


    void accessResource()
    {
        lock.lock();

        try
        {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+"Lock acquired");

        }
        catch (InterruptedException e)
        {

            System.out.println("Lock Interepted");

        }
        finally {
            System.out.println(Thread.currentThread().getName()+"releasingh the lock");
            lock.unlock();
        }

    }

    public static void main(String[] args) {

        Fair obj=new Fair();
        Runnable task=new Runnable() {
            @Override
            public void run() {
                obj.accessResource();
            }
        };
        Thread t1=new Thread(task,"t1");
        Thread t2=new Thread(task,"t2");
        Thread t3=new Thread(task,"t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
