package Synchronised;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Counter ct=new Counter();

        Mythreadf thread=new Mythreadf(ct);
        Mythreadf thread2=new Mythreadf(ct);
        thread.start();
        thread2.start();

        thread.join();
        thread2.join();

        System.out.println(ct.getCount());


    }

}
