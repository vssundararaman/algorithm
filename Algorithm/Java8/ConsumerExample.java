package Java8;

import java.util.function.Consumer;

/**
 * Example of Consumer functional interface in Java 8
 * A Consumer is a functional interface that represents an operation that takes a single input argument and returns no result.
 * It is often used for operations that have side effects, such as printing or modifying an object.
 */
public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> consumer = (s) -> System.out.println("Consumed: " + s);
        consumer.accept("Hello, World!");
    }
}
