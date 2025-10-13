package Java8.streams.practice;

import java.util.List;
import java.util.stream.IntStream;

public class Java8Streams {

    public static void main(String[] args) {


        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().skip(3).forEach(System.out::println);
        numbers.stream().limit(4).forEach( System.out::println);

        numbers.stream().filter(n->n%2==0).forEach(System.out::println);
        numbers.stream().filter(n->n%2!=0).forEach(System.out::println);

        System.out.println("----------------");
        // Reverse the stream
        numbers.stream().map(i -> numbers.get(numbers.size() - i)).forEach(System.out::println);


        List<Integer> num1 = List.of(1,2,3);
        List<Integer> num2 = List.of(3,2,1);

        num1.stream().flatMapToInt(i->num2.stream().mapToInt(j->i*j)).forEach(System.out::println);
    }
}
