package randomimportant;

public class ParenthesisChecker {

    public static void main(String[] args) {

        String s = "((()))()()";
        System.out.println(isBalanced(s));
        String s1 = "((()))";
        System.out.println(isBalanced(s1));
        String s2 = "()()";
        System.out.println(isBalanced(s2));
        String s3 = ")";
        System.out.println(isBalanced(s3));
    }

    static boolean isBalanced(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}
