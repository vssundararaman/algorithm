package JavaThread;

/**
 *  The difference between thread.run() and thread.start() lies in how the code within the run() method is executed:
 * thread.run():
 * When you directly call the run() method of a Thread object, the code inside the run() method executes within the current thread of execution, just like any other method call. This means no new thread is created, and the execution is synchronous.
 * thread.start():
 * When you call the start() method of a Thread object, it initiates the creation of a new, separate operating system thread. This new thread then asynchronously executes the code defined within the run() method of that Thread object.
 * This is the method to use when you want to achieve true multithreading and concurrent execution.
 */
public class ThreadDemo {

    public static void main(String[] args) {

		Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Namae: " + Thread.currentThread().getName());
            }
        });
        thread.run();
    }
}
