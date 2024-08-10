package Lock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;
import java.util.concurrent.locks.ReentrantLock;

public class Bankaccount {
    int ammount;
    int balance=0;
    private Lock lock=new ReentrantLock();
    Bankaccount(int ammount){
        balance=ammount;
        this.ammount=ammount;

    }

//    what if one thread is exceuting and not completing thats the drqwback of synhcronised
    public  void  deduct(int amm) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" is trying Executing");
         if(lock.tryLock(1000, TimeUnit.MILLISECONDS))
         {
             System.out.println(Thread.currentThread().getName()+"Get the Lock ");

             if(balance>=50)
             {
                 try{balance-=amm;
                     Thread.sleep(3000);
                     System.out.println(Thread.currentThread().getName()+"Excetued succ, remain balan"+balance);}
                 catch (Exception e){
                     System.out.println(e.getMessage());
                     Thread.currentThread().interrupt();
                 }
                 finally {
                     lock.unlock();
                 }


             }
             else
                 System.out.println(Thread.currentThread().getName()+"insuuficient balance");

             ammount-=50;
         }
         else
             System.out.println(Thread.currentThread().getName()+"Couldnt get the lock will try again later");



    }

    int getAmmount()
    {
        return balance;
    }

}
