package multithreading.example5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<File> queue;
    private Boolean isFinished;

    public Consumer(BlockingQueue<File> queue, Boolean isFinished) {
        this.queue = queue;
        this.isFinished = isFinished;
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
            while (!this.isFinished || !queue.isEmpty()) {
                File pyFile = queue.take();
                int numLines = countLines(pyFile.getAbsolutePath());
                System.out.printf("Consumer %s processed %s\n" +
                                "\tNumber lines = %d\n" +
                                "\tCurrent queue size = %d\n",
                        Thread.currentThread().getName(),
                        pyFile,
                        numLines,
                        queue.size());
            }
        } catch (InterruptedException | IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
