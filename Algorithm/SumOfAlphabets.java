/**
 * Find the Sum of Alphabets...
 */
public class SumOfAlphabets {

    public static void main(String[] args) {

        System.out.println(sumOfAlphabets("ABC"));
        System.out.println(sumOfAlphabets("abc"));
    }

    static int sumOfAlphabets(String s) {

        if (s.length() == 0) {
            return 0;
        }

        int sum = 0;
        for (char c : s.toCharArray()) {

            //c = Character.toUpperCase(c);

            if (Character.isLowerCase(c)) {
                sum += c - 'a' + 1;
            } else {
                sum += c - 'A' + 1;
            }

        }

        return sum;
    }
}
