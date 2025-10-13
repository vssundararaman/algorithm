package Numbers;

import java.util.stream.IntStream;

public class CheckPrimeNumber {

    public static boolean isPrime(int n) {
        if (n <=1) return false;
        return IntStream.
        rangeClosed(2, (int)Math.sqrt(n)).noneMatch(i -> n % i == 0);
   }

   public static void main(String[] args) {
        System.out.println(isPrime(10));
        System.out.println(isPrime(11));
   }
}
