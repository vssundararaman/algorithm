package JavaThread.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample {
    public static void main(String[] args) {

        try {
            example1();
            example2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Run task Asynchroniously
    public static void example1() throws Exception{
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Running task asynchronously" + Thread.currentThread().getName());
        });

        future.get();
     }

     // Supply a Result Asynchroniously
    public static void example2() throws Exception{
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Running task asynchronously" + Thread.currentThread().getName());
            return "Hello World";
        });

        System.out.println(future.get());
    }

    // then Apply example
    static void thenApplyExample() throws Exception{
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Java")
                .thenApply(s -> s + "8")
                .thenApply(s -> s + " is awesome")
                .thenApply(String::toUpperCase);

        System.out.println(future.get());
    }

//    //then accept example
//    static void thenAcceptExample() throws Exception{
//        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Java")
//                .thenAccept(s -> System.out.println(s + "8"))
//                .get();
//
//    }

}
