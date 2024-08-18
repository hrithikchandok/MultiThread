package MonitorLock;

import java.util.Arrays;
import java.util.List;

public class Producer implements  Runnable{

    private  SharedResouce sh;
    public Producer(SharedResouce sh) {
        this.sh=sh;
    }

    @Override
    public void run() {
        List<Integer>temp= Arrays.asList(10,22,5);
        int k=0;

        for(int i=0;i<3;i++)
        sh.addElement(temp.get(i));
    }
}
