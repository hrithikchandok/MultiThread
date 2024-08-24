package ThreadPool.Executor;

import java.util.concurrent.RecursiveTask;

public class ComputeSumTask extends RecursiveTask {

    int start;
    int last;
    public ComputeSumTask(int i, int i1) {
        start=i;
        last=i1;
    }


    @Override
    protected Integer compute() {

        int sum=0;
        if(last-start<=4)
        {
            for(int x=start;x<=last;x++)
                sum+=x;
            return sum;
        }
        else
        {
           int mid=(start+last)/2;

            ComputeSumTask computeSumTask1 = new ComputeSumTask(start,mid);
            ComputeSumTask computeSumTask2 = new ComputeSumTask(mid+1,last);

            computeSumTask1.fork();
            computeSumTask2.fork();

            Object join = computeSumTask2.join();
            Object join1 = computeSumTask1.join();

            return Integer.parseInt(join.toString())+Integer.parseInt(join1.toString());


        }


    }
}
