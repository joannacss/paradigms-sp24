package multithreading.example5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable {
    private BlockingQueue<File> queue;
    private AtomicInteger numProcessedFiles;
    private AtomicInteger totalFiles;
    private AtomicInteger numLines;


    public Consumer(BlockingQueue<File> queue, AtomicInteger numProcessedFiles, AtomicInteger totalFiles,AtomicInteger numLines) {
        this.queue = queue;
        this.numProcessedFiles = numProcessedFiles;
        this.totalFiles = totalFiles;
        this.numLines = numLines;
    }

    private static int countLines(String filePath) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                count++;
            }
        }
        return count;
    }

    public void run() {
        try {
            while (true) {

                File pyFile = queue.poll();
                if (pyFile == null) {
                    continue;
                }
                int totalLines = countLines(pyFile.getAbsolutePath());
                this.numLines.addAndGet(totalLines);
                System.out.printf("CONSUMER %s processed %s\n" +
                                "\tNumber lines = %d\n" +
                                "\tCurrent queue size = %d\n",
                        Thread.currentThread().getName(),
                        pyFile,
                        numLines.get(),
                        queue.size());
                int count = this.numProcessedFiles.incrementAndGet();
                if (count == this.totalFiles.get())
                    break;
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
