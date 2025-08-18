package Java8;

import java.util.function.Predicate;
/*
 * Example of Predicate functional interface in Java 8
 * A Predicate is a functional interface that represents a single argument function that returns a boolean value.
 * It is often used for filtering or matching conditions.
 *
 */
public class PredicateExample {

    public static void main(String[] args) {
        Predicate<Integer> predicate = (n) -> n > 10;
        System.out.println("Is 15 greater than 10? " + predicate.test(15)); // true
        System.out.println("Is 5 greater than 10? " + predicate.test(5 ));   // false

        predicateExample();
    }
    static  void predicateExample(){

            Predicate<String> isLongerThan5 = (s) -> s.length() > 5;
            System.out.println(isLongerThan5.test("Hello")); // false
            System.out.println(isLongerThan5.test("Hello, World!")); // true
    }
}
