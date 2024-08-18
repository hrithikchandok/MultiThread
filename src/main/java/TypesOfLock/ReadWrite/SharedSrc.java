package TypesOfLock.ReadWrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedSrc {


    public void producer(ReentrantReadWriteLock.WriteLock writeLock)
    {

        writeLock.lock();

        System.out.println("Writing lock is locked "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {

            System.out.println("Write lock is released"+Thread.currentThread().getName());
            writeLock.unlock();
        }


    }

    public void consumer(ReentrantReadWriteLock.ReadLock readLock)
    {
         readLock.lock();

        System.out.println("Reading lock is locked "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {

            System.out.println("read lock is released"+Thread.currentThread().getName());
            readLock.unlock();
        }
    }
}
