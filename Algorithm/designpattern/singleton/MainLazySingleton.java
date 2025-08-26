package designpattern.singleton;

public class MainLazySingleton {

    public static void main(String[] args) {
        LazySingleton lazySingleton = LazySingleton.getInstance();
        LazySingleton lazySingleton1 = LazySingleton.getInstance();

        System.out.println(lazySingleton == lazySingleton1);
        lazySingleton.showMessage();
    }
}
