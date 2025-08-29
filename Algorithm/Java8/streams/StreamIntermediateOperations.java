package Java8.streams;

import java.util.Arrays;
import java.util.List;

public class StreamIntermediateOperations {

    public static void main(String[] args) {
        StringIntermediateOperations();
        mapOperations();
        flatMapOperations();
        flatMapExample();
    }

    private static void StringIntermediateOperations() {
        List<String> names = List.of("Ramesh", "Amit", "Raj", "Ravi", "Raj",  "Ramesh");
        List<String> distinctNames = names.stream().distinct().toList();
        System.out.println(distinctNames);

        List<String> sortedNames = names.stream().sorted().toList();
        System.out.println(sortedNames);

        List<String> filteredNames = names.stream().filter(name->name.startsWith("R")).toList();
        System.out.println(filteredNames);
    }

    //Transform the number
    static void mapOperations() {

        List<String> names = List.of("Ramesh", "Amit", "Raj", "Ravi", "Raj",  "Ramesh");
        List<String> upperCaseNames = names.stream().map(String::toUpperCase).toList();
        System.out.println(upperCaseNames);
    }

    static void flatMapOperations() {
        List<String> names = List.of("Ramesh", "Amit", "Raj", "Ravi", "Raj",  "Ramesh");
        List<String> upperCaseNames = names.stream().flatMap(name->List.of(name, name.toUpperCase()).stream()).toList();
        System.out.println(upperCaseNames);
    }

    static void flatMapExample() {
        List<String> student1 = Arrays.asList("Maths", "English");
        List<String> student2 = Arrays.asList("Science", "English", "History");
        List<String> student3 = Arrays.asList("Maths", "Computer");

        List<List<String>> allSubjects = Arrays.asList(student1, student2, student3);

        System.out.println("Without FlatMap:" + allSubjects);

        allSubjects.stream().flatMap(list -> list.stream()).distinct().forEach(System.out::println);

    }
}
