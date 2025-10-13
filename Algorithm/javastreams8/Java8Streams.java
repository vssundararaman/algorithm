package javastreams8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Streams {

    public static void main(String[] args) {
        List<String> names = List.of("Ramesh", "Kumar", "Sankar");
        List<String> result = names.stream()
                .filter(n -> n.contains("R"))
                .toList();
        System.out.println("Filtered: " + result);

        // Sorting examples
        List<String> sortedNames = names.stream()
                .sorted()
                .toList();
        System.out.println("Natural sort: " + sortedNames);

        List<String> lengthSortedNames = names.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .toList();
        System.out.println("Length sort: " + lengthSortedNames);

        // IntStream examples
        System.out.println("\nIntStream Methods:");

        System.out.println("Range:");
        IntStream.range(1, 5).forEach(System.out::print);

        System.out.println("\nRangeClosed:");
        IntStream.rangeClosed(1, 5).forEach(System.out::print);

        System.out.println("\nIterate:");
        IntStream.iterate(1, n -> n <= 5, n -> n + 1).forEach(System.out::print);

        System.out.println("\nGenerate (first 5 random numbers):");
        IntStream.generate(() -> (int) (Math.random() * 100))
                .limit(5)
                .forEach(System.out::print);

        int sum = IntStream.of(1, 2, 3, 4, 5).sum();
        System.out.println("\nSum: " + sum);

        double average = IntStream.of(1, 2, 3, 4, 5)
                .average()
                .orElse(0.0);
        System.out.println("Average: " + average);

        System.out.println("Max: " + IntStream.of(1, 2, 3, 4, 5).max().getAsInt());
        System.out.println("Min: " + IntStream.of(1, 2, 3, 4, 5).min().getAsInt());
        System.out.println("Count: " + IntStream.of(1, 2, 3, 4, 5).count());
        System.out.println("Distinct: " + IntStream.of(1, 1, 2, 2, 3).distinct().count());
        System.out.println("All match (>0): " + IntStream.of(1, 2, 3, 4, 5).allMatch(n -> n > 0));
        System.out.println("Any match (>4): " + IntStream.of(1, 2, 3, 4, 5).anyMatch(n -> n > 4));

        List<Integer> numbers = Arrays.asList(5, 12, 8, 12, 7, 3, 20);

        List<Integer> result1 = numbers.stream()
                .filter(n -> n > 5)                 // Keep numbers greater than 5
                .distinct()                         // Remove duplicates
                .sorted()                           // Sort in ascending order
                .map(n -> n * 2)                    // Double each number
                .peek(System.out::println)          // Print each (for debugging)
                .limit(3)                           // Take first 3
                .collect(Collectors.toList());      // Terminal operation

        System.out.println("Final Result: " + result1);
    }
}
