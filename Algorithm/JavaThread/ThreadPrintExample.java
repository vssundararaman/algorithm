package JavaThread;

public class ThreadPrintExample {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Child Thread " + i);
                try {
                    Thread.sleep(500); // Sleep for 500 milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        System.out.println("Main Thread Started");
        System.out.println("Thread is finished");

    }
}
