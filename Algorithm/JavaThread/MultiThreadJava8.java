package JavaThread;

public class MultiThreadJava8 {

    public static void main(String[] args) {
        MultiThread();
    }

    private static void MultiThread() {
        Runnable task = () -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " - Count: " + i);
                try {
                    Thread.sleep(500); // Simulate some work with sleep
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread thread1 = new Thread(task, "Worker-1");
        Thread thread2 = new Thread(task, "Worker-2");

        thread1.start();
        thread2.start();

//        thread1. run();
//        thread2. run();
    }
}
