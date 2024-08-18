package TypesOfLock.ret;

import java.util.concurrent.locks.ReentrantLock;

public class SharedRrc
{
  ReentrantLock lock=new ReentrantLock();
  public void producer()
  {
      lock.lock();

      System.out.println("Lock aquired by "+Thread.currentThread().getName());

      try {
          Thread.sleep(10000);
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }
      finally {
          System.out.println("Lock is released"+Thread.currentThread().getName());
          lock.unlock();
      }


  }

}
