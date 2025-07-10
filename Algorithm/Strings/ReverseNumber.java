package Strings;

/**
 * Reverse the number
 */
public class ReverseNumber{
    public static void main(String[] args) {
        System.out.println(reverseNumber(1234));
    }

    static int reverseNumber(int num) {
        int result = 0;
   
        int sign = num<0 ?-1: 1;
        num = Math.abs(num);

        while(num!=0){
            int digit = num % 10;
            result = result * 10 + digit;
            num = num/10;
        }
        return sign * result;
    }
}