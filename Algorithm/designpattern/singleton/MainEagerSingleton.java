package designpattern.singleton;

public class MainEagerSingleton {

    public static void main(String[] args) {
        EagarSingleton singleton = EagarSingleton.getInstance();
        EagarSingleton singleton1 = EagarSingleton.getInstance();
        singleton.showMessage();
        System.out.println(singleton == singleton1); // true
        singleton.showMessage();
        singleton1.showMessage();
    }
}
