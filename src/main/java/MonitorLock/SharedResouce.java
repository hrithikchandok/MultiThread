package MonitorLock;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SharedResouce {


    Queue<Integer>q1=new ArrayDeque<>(10);


    public synchronized void addElement(Integer ele)
    {
         while(q1.size()>=10)
         {
             System.out.println("Producer is waiting for the consumer");
             try {
                 wait();
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }
        System.out.println("Producer added the element"+ele);
         q1.add(ele);
         notify();

    }

    public synchronized int getElement()
    {
       while(q1.size()==0)
       {
           System.out.println("Consumer is waiting for the producer");
           try {
               wait();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }

        System.out.println("Consumer get the elemnt "+q1.peek());
        notify();
       return q1.poll();


    }
}
