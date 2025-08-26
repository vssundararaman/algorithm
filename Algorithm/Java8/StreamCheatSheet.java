package Java8;

import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    String dept;
    double salary;

    Employee(String name, String dept, double salary) {
        this.name = name; this.dept = dept; this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " (" + dept + ", $" + salary + ")";
    }
}

public class StreamCheatSheet {
    public static void main(String[] args) {
        List<String> names = MapStrings();

        // 2. flatMap
        System.out.println("\n2️⃣ flatMap:");
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5),
                Arrays.asList(6,7,8));
        List<Integer> flat = numbers.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(flat);

        // 3. reduce
        System.out.println("\n3️⃣ reduce (sum):");
        int sum = Arrays.asList(2,4,6,8).stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);

        // 4. Collectors (joining, grouping, counting)
        System.out.println("\n4️⃣ Collectors:");
        String joined = names.stream().collect(Collectors.joining(", "));
        System.out.println("Joined: " + joined);
        Map<Integer, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length: " + grouped);
        Map<String, Long> counted = names.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println("Counted: " + counted);

        // 5. Parallel stream
        System.out.println("\n5️⃣ Parallel stream sum:");
        int parallelSum = IntStream.rangeClosed(1, 10).parallel().sum();
        System.out.println(parallelSum);

        // 6. Custom collector
        System.out.println("\n6️⃣ Custom collector:");
        String customCollected = names.stream().collect(
                StringBuilder::new,
                (sb, str) -> sb.append(str).append("-"),
                StringBuilder::append
        ).toString();
        System.out.println(customCollected);

        // 7. Infinite Streams
        System.out.println("\n7️⃣ Infinite Streams (first 5 even numbers):");
        Stream.iterate(0, n -> n + 2).limit(5).forEach(System.out::println);

        // 8. Sorting
        System.out.println("\n8️⃣ Sorting:");
        List<String> sorted = names.stream()
                .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
        System.out.println(sorted);

        // 9. Optional + Stream
        System.out.println("\n9️⃣ Optional + Stream:");
        names.stream().filter(n -> n.startsWith("A")).findFirst()
                .ifPresent(System.out::println);

        // 10. Employee analytics (real-world example)
        System.out.println("\n🔟 Employee analytics:");
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 6000),
                new Employee("Bob", "HR", 4000),
                new Employee("Charlie", "IT", 7000),
                new Employee("David", "Finance", 8000),
                new Employee("Eva", "HR", 4500)
        );

        // Highest salary per dept
        Map<String, Optional<Employee>> topSalaries = employees.stream()
                .collect(Collectors.groupingBy(e -> e.dept,
                        Collectors.maxBy(Comparator.comparingDouble(e -> e.salary))));
        System.out.println("Top salaries: " + topSalaries);

        // Average salary per dept
        Map<String, Double> avgSalary = employees.stream()
                .collect(Collectors.groupingBy(e -> e.dept,
                        Collectors.averagingDouble(e -> e.salary)));
        System.out.println("Average salary: " + avgSalary);
    }

    private static List<String> MapStrings() {
        // 1. Basic Stream operations
        List<String> names = Arrays.asList("John", "Alice", "Bob", "David", "Alice");
        System.out.println("\n1️⃣ Basic filter + map:");
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(result);
        return names;
    }
}
