package Java8.streams.practice;

import java.util.Arrays;
import java.util.List;

public class StreamOperationsDemo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("ram","sita","ram","hanuman", "laks");
        System.out.println(" Stream Line Operations: ");

        names.stream()
                .filter(n -> n.startsWith("r"))
                .forEach(System.out::println);

        System.out.println(" --------------------- ");
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println(" --------------------- ");
        names.stream()
                .distinct()
                .forEach(System.out::println);

    }
}
