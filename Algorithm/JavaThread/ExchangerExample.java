package JavaThread;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        // Thread 1
        new Thread(() -> {
            try {
                String dataToGive = "Data from Thread 1";
                System.out.println(Thread.currentThread().getName() + " sending: " + dataToGive);
                String receivedData = exchanger.exchange(dataToGive);
                System.out.println(Thread.currentThread().getName() + " received: " + receivedData);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Thread-1").start();

        // Thread 2
        new Thread(() -> {
            try {
                String dataToGive = "Data from Thread 2";
                System.out.println(Thread.currentThread().getName() + " sending: " + dataToGive);
                String receivedData = exchanger.exchange(dataToGive);
                System.out.println(Thread.currentThread().getName() + " received: " + receivedData);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Thread-2").start();

    }
}
