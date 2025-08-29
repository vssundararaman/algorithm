package Java8.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Runnable task1 = () -> System.out.println("Task 1 executed by " + Thread.currentThread().getName());
        Runnable task2 = () -> System.out.println("Task 1 executed by " + Thread.currentThread().getName());
        Runnable task3 = () -> System.out.println("Task 1 executed by " + Thread.currentThread().getName());


        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);
        executor.shutdown();
    }
}
