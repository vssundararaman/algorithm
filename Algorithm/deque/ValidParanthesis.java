package deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParanthesis {

    public static void main(String[] args) {
        System.out.println(validParenthesis("()[]{}")); // true
        System.out.println(validParenthesis("(]"));
        System.out.println(validParenthesis(")()"));
    }

    static boolean validParenthesis(String s){

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                deque.push(c);
            } else {
                if (deque.isEmpty()) return false;
                char top = deque.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{'))
                    return false;
            }
        }
        return deque.isEmpty();
    }
}
