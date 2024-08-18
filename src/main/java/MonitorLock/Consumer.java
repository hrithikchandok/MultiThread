package MonitorLock;

public class Consumer implements Runnable {

     private SharedResouce sh;

    public Consumer(SharedResouce sharedResouce) {
        this.sh = sharedResouce;
    }

    @Override
    public void run() {

        for(int i=0;i<6;i++)
      sh.getElement();


    }
}
