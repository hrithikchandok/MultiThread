package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main extends Thread {

    Main(String name)
    {
        super(name);
    }

    public static void main(String[] args) throws InterruptedException {


        Main t1=new Main("t1");
        t1.setDaemon(true);
        t1.start();
        Main t2=new Main("t2");
        t2.start();


//        t1.setPriority(1);
//        t2.setPriority(10);

        System.out.println("Main thread");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getState());
        System.out.println("main thread end");
//        t1.sleep(2000);
//        t1.join(); // main thread will wait for the t1 to get finished


    }

    @Override
    public void run() {
         for(int i=0;i<5;i++)
         {
             System.out.println(Thread.currentThread().getName()+"-count "+i);
              Thread.yield();

         }
    }
}