package designpattern.singleton;

public class EagarSingleton {
    private static final EagarSingleton instance = new EagarSingleton();

    private EagarSingleton(){}

    public static final EagarSingleton getInstance(){
        return instance;
    }
    public void showMessage() {
        System.out.println("Hello from Eager Singleton!");
    }
}
