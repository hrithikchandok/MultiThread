package TypesOfLock.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.StampedLock;

public class Src {

    Semaphore lock=new Semaphore(2);
    public void producer() {
        try {

            lock.acquire();
            System.out.println(Thread.currentThread().getName()+"Trying to aquire the lock");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {

            System.out.println(Thread.currentThread().getName()+"Releases the lock");
            lock.release();
        }

    }
}
