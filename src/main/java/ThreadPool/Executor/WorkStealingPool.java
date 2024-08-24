package ThreadPool.Executor;

import java.util.concurrent.*;

public class WorkStealingPool {

    public static void main(String[] args) {

        ForkJoinPool pool= ForkJoinPool.commonPool();
        Future<?>future = pool.submit(new ComputeSumTask(0, 100));

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End---");


    }
}
