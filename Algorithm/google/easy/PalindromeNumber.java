package google.easy;

/**
 * 9. Palindrome Number
 * Solved
 * Easy
 * Topics
 * conpanies icon
 * Companies
 * Hint
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
public class PalindromeNumber {

    public static void main(String[] args) {

        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(1234321));
    }

    static boolean isPalindrome(int x) {

        int value = x;
        int result = 0;

        while (x >0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }

        return value == result;
    }
}
