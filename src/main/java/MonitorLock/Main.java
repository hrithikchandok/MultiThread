package MonitorLock;

public class Main {
    public static void main(String[] args) {

        SharedResouce sh=new SharedResouce();


        Thread t1=new Thread(new Consumer(sh));
        Thread t2=new Thread(new Producer(sh));
        t1.start();
        t2.start();
    }
}
