package Java8.streams;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {

    public static void main(String[] args) {

        List<Integer> employeeAgeList = List.of(20, 22, 25, 23, 21);
        List<Integer> studentAgeList = List.of(18, 19, 17, 20, 21);

        List<List<Integer>> ageList = Arrays.asList( employeeAgeList,studentAgeList);

        ageList.stream().flatMap(list -> list.stream())
                .distinct()
                .sorted().forEach(System.out::println);
    }
}
