package Java8;

import java.time.LocalDate;
import java.util.function.Supplier;

/**
 * Example of Supplier functional interface in Java 8
 * A Supplier is a functional interface that represents a supplier of results.
 * It does not take any arguments and returns a result.
 * It is often used for lazy generation of values or objects.
 */
public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> LocalDate.now().toString();
        System.out.println("Current Date and Time: " + supplier.get());


    }
}
