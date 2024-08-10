package ReadWriteLock;
import java.util.concurrent.locks.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RW {

    private final ReadWriteLock lock=new ReentrantReadWriteLock();
    private final Lock read=lock.readLock();
    private final Lock write=lock.writeLock();
     int count=0;


    void Incremeent()
    {
        write.lock();
        try
        {
            count++;
            System.out.println(Thread.currentThread().getName()+"Wrting the value"+count);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
        finally {

             write.unlock();
        }

    }
    int getCount()
    {
        read.lock();
        try
        {
            System.out.println(Thread.currentThread().getName()+"read the count "+count);
            return count;
        }
        finally {
            read.unlock();
        }


    }



    public static void main(String[] args)
    {
        RW  obj=new RW();
        Runnable task1=new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++)
                   obj.getCount();
            }
        };

        Runnable task2=new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++)
                obj.Incremeent();
            }
        };

        Thread t1=new Thread(task1,"r1");
        Thread t2=new Thread(task1,"r2");
        Thread t3=new Thread(task2,"w1");



            t1.start();
            t2.start();
            t3.start();



    }
}
