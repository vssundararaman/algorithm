package JavaThread;

public class MultiThread8WithSync {

    public static void main(String[] args) {
        final Object lock = new Object(); // Shared lock object
        Runnable runnable = () -> {
            for (int i = 0; i < 20; i++) {
                synchronized (lock) { // Synchronize on the shared lock object
                    System.out.println("Thread Name: " + Thread.currentThread().getName() + " - Count: " + i);
                }
                try {
                    Thread.sleep(500); // Simulate some work with sleep
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread thread1 = new Thread(runnable, "Worker-1");
        Thread thread2 = new Thread(runnable, "Worker-2");
        thread1.start();
        thread2.start();
    }
}
