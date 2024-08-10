package Synchronised;

import com.sun.source.tree.SynchronizedTree;

public class Counter {

    private int count=0;

    Counter(){
        this.count=count;
    }

    // critical section
    // shared resource
    // has to be symchromised
     public synchronized   void  increment()
    {
        count++;
    }

    int getCount()
    {
        return  count;
    }


}
