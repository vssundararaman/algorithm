package Java8.streams;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamsMultipleWays {

    public static void main() {
        fromCollectionsStreams();
    }

    static void fromCollectionsStreams() {
        List<String> names = List.of("Adam", "Eve", "Ramesh");
        Stream<String> namesString = names.stream();
        namesString.forEach(System.out::println);
        System.out.println(" --------------------- ");
        names.stream().forEach(System.out::println);
        System.out.println(" --------------------- ");

        // From Arrays
        int[] noStream = {4,2,12,3};
        Stream<int[]> numStream = Stream.of(noStream);
        numStream.forEach(System.out::println);


        Stream<String> furitStream = Stream.of("Apple", "Banana", "Orange");
        furitStream.forEach(s -> System.out.print(s + " "));

        //Generate Stream
        Stream<String> helloStream = Stream.generate(() -> "Hello");
        helloStream.limit(5).forEach(System.out::println);

        //Creating a Stream with Iterate String

        Stream<Integer> numberStream = Stream.iterate(5, n -> n % 5).limit(15);
        numberStream.forEach(s -> System.out.print(s + " "));
    }
}
