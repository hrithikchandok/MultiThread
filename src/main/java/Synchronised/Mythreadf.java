package Synchronised;

public class Mythreadf extends Thread{


    int count =0;
    Counter ct;
      Mythreadf(Counter ct)
    {
        this.ct=ct;
    }

    @Override
    public void run() {

          for(int i=0;i<1000;i++)
             ct.increment();


    }
}
