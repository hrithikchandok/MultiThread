package TypesOfLock.ReadWrite;

import TypesOfLock.ret.SharedRrc;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {

        SharedSrc src=new SharedSrc();

        ReentrantReadWriteLock lock=new ReentrantReadWriteLock();

        Thread t1=new Thread(()-> src.producer(lock.writeLock()));
        Thread t2=new Thread(()->src.consumer(lock.readLock()));
        Thread t3=new Thread(()->src.consumer(lock.readLock()));

        t1.start();
        t2.start();
        t3.start();

    }
}
