package TypesOfLock.Semaphore;

public class Main {

    public static void main(String[] args) {

        Src src=new Src();
        Thread T1=new Thread(()->src.producer());
        Thread T2=new Thread(()->src.producer());
        Thread T3=new Thread(()->src.producer());
        T1.start();
        T2.start();
        T3.start();
    }

}
