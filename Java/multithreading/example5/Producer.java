package multithreading.example5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<File> queue;
    private File folder;
    private Boolean isFinished;
    public Producer(BlockingQueue<File> queue, File folder, Boolean isFinished) {
        this.queue = queue;
        this.folder = folder;
        this.isFinished = isFinished;
    }

    @Override
    public void run() {
        Path p = Paths.get(this.folder.getAbsolutePath());
        try {
            Files.walk(p)
                    .filter(path -> Files.isRegularFile(path) && path.toString().endsWith(".py"))
                    .forEach(file -> {
                        try {
                            queue.put(file.toFile());
                            System.out.printf("Found file=%s\n", file);
                        } catch (InterruptedException e) {
                            System.out.println("Error while adding to queue: " + e.getMessage());
                        }
                    });
        } catch (IOException e) {
            // print error message
            System.out.println(e.getMessage());
        }
        this.isFinished = true;
    }


//    public void run() {
//		try{
//			// no synchronization needed will be needed
//			int value = 0;
//			while (true) {
//				queue.put(value);
//				System.out.printf("Produced=%d\n", value);
//				value++;
//				Thread.sleep(200);
//			}
//		}catch(InterruptedException ex){
//			System.err.println(ex.getMessage());
//		}
//    }
}
