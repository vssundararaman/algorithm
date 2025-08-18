package Java8;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, Integer> square = (n) -> n * n * n; // Cube function
        System.out.println(square.apply(5));
    }
}
