package AwaitSignal;


//Await and signal is used in custom lock
//----------------VS--------------
//Wait and notify is used in syncrhonized lock
//
//They all are used for Inter Thread communication
public class Main {
    public static void main(String[] args)
    {
        SharedSrc src=new SharedSrc();

        Thread t1 =new Thread(()->src.producer());
        Thread t2=new Thread(()->src.consumer());

        t1.start();
        t2.start();
    }
}
