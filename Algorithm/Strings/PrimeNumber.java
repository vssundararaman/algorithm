package Strings;

import java.util.stream.IntStream;

public class PrimeNumber {
    
    public static void main(String[] args) {
        findPrimeNumber(100);
    }

    static void findPrimeNumber(int n) {
        IntStream.rangeClosed(1, n).filter(PrimeNumber::isPrime).forEach(i->System.out.println(i + " "));
    }

    static boolean isPrime(int n){
        return n > 1 && IntStream.rangeClosed(2, (int)Math.sqrt(n)).allMatch(i -> n % i != 0);
    }
}
