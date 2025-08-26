package Java8;

import java.util.Arrays;

public class JavaStreamsWithExamples {

    public static void main(String[] args) {
        streamExamples();
        multiplyByTwo();
        flatMapExample();
    }

    static void streamExamples() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Example: Filter even numbers and print them
        System.out.println("Even numbers:");
        Arrays.stream(array).filter(n -> n % 2 == 0).forEach(System.out::println);
    }

    static void multiplyByTwo() {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(array).map(n -> n * 2).forEach(System.out::println);
    }

    static void flatMapExample() {
        // Example: Flatten a list of lists and print all elements
        System.out.println("Flattened list:");
        java.util.List<java.util.List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        listOfLists.stream()
                .flatMap(java.util.Collection::stream)
                .forEach(System.out::println);
    }
}
