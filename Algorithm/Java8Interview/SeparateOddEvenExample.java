package Java8Interview;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SeparateOddEvenExample {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.stream(numbers).forEach(System.out::println);
        System.out.println("---------------------------");
        Arrays.stream(numbers).filter(n->n%2==0).forEach(System.out::println);
        System.out.println("---------------------------");
        Arrays.stream(numbers).filter(n->n%2!=0).forEach(System.out::println);

        System.out.println("---------------------------Reverse Arrays");
        Arrays.stream(numbers).map(i -> numbers[numbers.length - i]).forEach(System.out::println);

        System.out.println("Find Palindrome");
        String word = "madam";
        
        boolean isPalindrome = IntStream.range(0, word.length() / 2)
                .allMatch(i -> word.charAt(i) == word.charAt(word.length() - i - 1));

        System.out.println(word + " is palindrome? " + isPalindrome);
    }
}
