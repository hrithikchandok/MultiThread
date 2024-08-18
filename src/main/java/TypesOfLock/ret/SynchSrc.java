package TypesOfLock.ret;

public class SynchSrc {

    public synchronized  void producer()
    {
        System.out.println("Lock aquired by "+Thread.currentThread().getName());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Lock is getting released");
        }


    }

}
