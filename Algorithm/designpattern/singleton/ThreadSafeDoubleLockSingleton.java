package designpattern.singleton;

public class ThreadSafeDoubleLockSingleton {
    private static volatile ThreadSafeDoubleLockSingleton instance;

    private ThreadSafeDoubleLockSingleton(){}

    public static ThreadSafeDoubleLockSingleton getInstance(){
        if(instance == null){
            synchronized (ThreadSafeDoubleLockSingleton.class){
                if(instance == null){
                    instance = new ThreadSafeDoubleLockSingleton();
                }
            }
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Thread Safe Double Lock Singleton!");
    }
}
