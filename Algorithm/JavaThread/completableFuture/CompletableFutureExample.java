package JavaThread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {
    public static void main(String[] args) {
        System.out.println("CompletableFuture Example");
        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println( "Main Thread Name" + Thread.currentThread().getName() );

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println( "Thread Name" + Thread.currentThread().getName() );
            return "Hello World";
        }, executor)
        .thenApplyAsync(result -> {
            System.out.println( "Thread Name" + Thread.currentThread().getName() );
            return result.toUpperCase();
        }, executor).thenApplyAsync(result -> {
            System.out.println( "Thread Name" + Thread.currentThread().getName() );
            return result + "!!!";
        }, executor);
    }
}
