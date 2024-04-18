package multithreading.example5;

import java.io.File;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        File directory = new File("/Users/joanna/Documents/Portfolio/GitHub/joannacss/paradigms-sp24/");
        // shared data structure (blocking queue. size = 10)
        BlockingQueue<File> bq = new LinkedBlockingQueue<>();
        AtomicInteger totalFiles = new AtomicInteger(0);
        AtomicInteger numProcessedFiles = new AtomicInteger(0);
        AtomicInteger numLines = new AtomicInteger(0);
        // producer
        Producer p = new Producer(bq, directory, totalFiles);
        // consumers
        Consumer c1 = new Consumer(bq, numProcessedFiles, totalFiles, numLines);
        Consumer c2 = new Consumer(bq, numProcessedFiles, totalFiles, numLines);
        // execute the tasks with an ExecutorService
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(p);
        executor.execute(c1);
        executor.execute(c2);
        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);
        System.out.println("Main finished");
        System.out.println("\tTotal files found: " + totalFiles.get());
        System.out.println("\tTotal number of lines: " + numLines.get());
    }
}


