package TypesOfLock.Stamped;

import java.util.concurrent.locks.StampedLock;

public class SharedSrc {

    StampedLock lock=new StampedLock();
    int a=10;


    public void produccer() {

        long stamp = lock.tryOptimisticRead();

        System.out.println("Reading lock is locked "+Thread.currentThread().getName());
        try {
            Thread.sleep(6000);
            if(lock.validate(stamp))
                System.out.println("value of a is "+a);
            else
            {System.out.println("Rocll back");
                 a=10;}


//                System.out.printlnln("value of args is "+a);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {

            System.out.println("Write lock is released"+Thread.currentThread().getName());
//            lock.unlockRead(stamp);
        }

    }

    public void consumer() {

        long stamp=lock.writeLock();

        System.out.println("Writing lock is locked "+Thread.currentThread().getName());

        a=11;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println();
            lock.unlockWrite(stamp);
        }

    }
}
