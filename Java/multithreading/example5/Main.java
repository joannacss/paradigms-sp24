package multithreading.example5;

import java.io.File;
import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        File directory = new File("/Users/joanna/Documents/Portfolio/GitHub/joannacss/paradigms-sp24/");
        // shared data structure (blocking queue. size = 10)
        BlockingQueue<File> bq = new LinkedBlockingQueue<>();
        boolean isFinished = false;
        // producer
        Producer p = new Producer(bq, directory, isFinished);
        // consumers
        Consumer c1 = new Consumer(bq, isFinished);
        Consumer c2 = new Consumer(bq, isFinished);
        // execute the tasks with an ExecutorService
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(p);
        executor.execute(c1);
        executor.execute(c2);
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
}


