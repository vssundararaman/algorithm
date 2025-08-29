package Java8.streams;

import java.util.List;
import java.util.function.Function;

public class FunctionalInterfaceStream {

    public static void main(String[] args) {


        Function<Integer, Integer> findYear = (age) -> 2025 - age;
        System.out.println(findYear.apply(45));

        List<Integer> ages = List.of(23, 45, 67, 89, 12, 34, 56);
        ages.stream().map(findYear).forEach(System.out::println);
    }

}
