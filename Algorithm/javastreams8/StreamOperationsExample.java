package javastreams8;

import java.util.*;
import java.util.stream.Collectors;

public class StreamOperationsExample {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25, 10, 5);

        System.out.println("=== INTERMEDIATE OPERATIONS ===");

        // 1️⃣ filter() - Keep elements matching condition
        List<Integer> filtered = numbers.stream()
                .filter(n -> n > 10)
                .collect(Collectors.toList());
        System.out.println("filter(n > 10): " + filtered);

        // 2️⃣ map() - Transform each element
        List<Integer> mapped = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("map(n * 2): " + mapped);

        // 3️⃣ flatMap() - Flatten nested structures
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Tom", "Jerry"),
                Arrays.asList("Mickey", "Donald"));
        List<String> flatMapped = namesNested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("flatMap(List::stream): " + flatMapped);

        // 4️⃣ distinct() - Remove duplicates
        List<Integer> distinct = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinct(): " + distinct);

        // 5️⃣ sorted() - Sort elements
        List<Integer> sortedAsc = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("sorted() ascending: " + sortedAsc);

        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("sorted() descending: " + sortedDesc);

        // 6️⃣ limit() - Take first N elements
        List<Integer> limited = numbers.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("limit(3): " + limited);

        // 7️⃣ skip() - Skip first N elements
        List<Integer> skipped = numbers.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("skip(3): " + skipped);

        // 8️⃣ peek() - Debug/log each element
        System.out.println("peek(): ");
        numbers.stream()
                .peek(n -> System.out.println("Processing: " + n))
                .map(n -> n * 2)
                .collect(Collectors.toList());

        System.out.println("\n=== TERMINAL OPERATIONS ===");

        // 1️⃣ forEach() - Perform action on each element
        System.out.print("forEach(): ");
        numbers.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 2️⃣ collect() - Gather results
        List<Integer> collected = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("collect(toList()): " + collected);

        // 3️⃣ count() - Count elements
        long count = numbers.stream().filter(n -> n > 10).count();
        System.out.println("count(n > 10): " + count);

        // 4️⃣ findFirst() - Get first element
        Optional<Integer> first = numbers.stream().findFirst();
        System.out.println("findFirst(): " + first.orElse(null));

        // 5️⃣ findAny() - Get any element (useful in parallel streams)
        Optional<Integer> any = numbers.parallelStream().findAny();
        System.out.println("findAny(): " + any.orElse(null));

        // 6️⃣ anyMatch() - Check if any match condition
        boolean anyMatch = numbers.stream().anyMatch(n -> n > 20);
        System.out.println("anyMatch(n > 20): " + anyMatch);

        // 7️⃣ allMatch() - Check if all match condition
        boolean allMatch = numbers.stream().allMatch(n -> n >= 5);
        System.out.println("allMatch(n >= 5): " + allMatch);

        // 8️⃣ noneMatch() - Check if none match condition
        boolean noneMatch = numbers.stream().noneMatch(n -> n < 0);
        System.out.println("noneMatch(n < 0): " + noneMatch);

        // 9️⃣ reduce() - Reduce elements to a single result
        Optional<Integer> reducedSum = numbers.stream()
                .reduce((a, b) -> a + b);
        System.out.println("reduce(sum): " + reducedSum.orElse(0));

        // 1️⃣0️⃣ min() / max()
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println("min(): " + min.orElse(null));
        System.out.println("max(): " + max.orElse(null));

        // 1️⃣1️⃣ toArray()
        Integer[] array = numbers.stream().toArray(Integer[]::new);
        System.out.println("toArray(): " + Arrays.toString(array));

        // 1️⃣2️⃣ summarize statistics
        IntSummaryStatistics stats = numbers.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        System.out.println("summaryStatistics(): " + stats);

        System.out.println("\n=== COMBINED PIPELINE EXAMPLE ===");

        List<String> finalResult = namesNested.stream()
                .flatMap(List::stream)          // Flatten
                .filter(name -> name.length() > 4)
                .map(String::toUpperCase)
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("Final Names: " + finalResult);
    }
}
