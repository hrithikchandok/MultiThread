package TypesOfLock.Stamped;

public class Main {
    public static void main(String[] args) {


        SharedSrc src=new SharedSrc();

        Thread t1=new Thread(()->src.produccer());
        Thread t2=new Thread(()->src.consumer());
         t1.start();
         t2.start();
    }
}
