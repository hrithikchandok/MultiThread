package LockFreeConcurency;

import java.util.concurrent.atomic.AtomicInteger;

public class LockFree
{
    AtomicInteger counter=new AtomicInteger();


//    Lock free
//    No Synchronized
//    Faster than synchronized
//  but only used for read , update , modify


    void increment()

    {
        counter.getAndIncrement();


    }

    Integer getElement()
    {
        return counter.get();
    }




}
