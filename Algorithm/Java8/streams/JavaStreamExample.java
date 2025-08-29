package Java8.streams;

import java.util.List;

public class JavaStreamExample {

    public static void main(String[] args) {
        ForEachExample();
    }

    private static void ForEachExample() {
        List<String> names = List.of("Ramesh", "Amit", "Raj", "Ravi", "Raj",  "Ramesh");
        names.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println(" --------------------- ");
        names.stream().distinct().forEach(System.out::println);
        System.out.println(" --------------------- ");
        names.stream().sorted().forEach(System.out::println);
        System.out.println(" --------------------- ");
        names.stream().filter(name->name.startsWith("A")).forEach(System.out::println);
        System.out.println(" --------------------- ");
    }
}
