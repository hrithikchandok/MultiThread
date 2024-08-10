package Lock;

import java.util.logging.Logger;

public class Main  {
    public static void main(String[] args) {

        Bankaccount obj=new Bankaccount(100);
//        Logger LOGGER = new Logger("Loggin start");

        Runnable Th=new Runnable() {
            @Override
            public void run() {
                try {
                    obj.deduct(50);
                } catch (InterruptedException e) {
//                    logger.info()

                    throw new RuntimeException(e);
                }

            }
        };
        Thread t2=new Thread(Th,"Thread1");
        Thread t3=new Thread(Th,"Thread2");
        t2.start();
        t3.start();

        System.out.println(obj.getAmmount());




    }
}
