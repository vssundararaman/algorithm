package JavaThread;

public class ThreadDemo8 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        });
    }
}
