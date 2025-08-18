package JavaThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() ->
                System.out.println("Task 1" + " - Thread Name: " + Thread.currentThread().getName()));

        executor.submit(() ->
                System.out.println("Task 2" + " - Thread Name: " + Thread.currentThread().getName()));

        executor.shutdown();
    }
}
