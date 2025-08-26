package designpattern.singleton;

public class ThreadSafeMainLazySingleton {

    public static void main(String[] args) {
        ThreadSafeLazySingleton lazySingleton = ThreadSafeLazySingleton.getInstance();
        ThreadSafeLazySingleton lazySingleton1 = ThreadSafeLazySingleton.getInstance();

        System.out.println(lazySingleton == lazySingleton1);
        lazySingleton.showMessage();


        ThreadSafeDoubleLockSingleton doubleLockSingleton = ThreadSafeDoubleLockSingleton.getInstance();
        ThreadSafeDoubleLockSingleton doubleLockSingleton1 = ThreadSafeDoubleLockSingleton.getInstance();
        System.out.println(doubleLockSingleton == doubleLockSingleton1);
        doubleLockSingleton.showMessage();
    }
}
