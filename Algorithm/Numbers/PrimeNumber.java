package Numbers;

import java.util.stream.IntStream;

public class PrimeNumber {

    public static void main(String[] args) {
        int number = 29; // Example number to check
        boolean isPrime = isPrime(number);
        System.out.println(number + " is prime: " + isPrime);
    }
    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    }
}
