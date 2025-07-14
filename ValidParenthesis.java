
import java.util.Stack;

public class ValidParenthesis{

    public static void main(String[] args) {
        String input = "{[()]}";
        System.out.println("Is valid? " + ValidParenthesis(input));
    }

    static boolean ValidParenthesis(String s) {

        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()) {

            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
           else if (ch == ')' || ch== ']' || ch=='}') {
                if(stack.isEmpty()) return false;

                char top = stack.pop();
                if((ch == ')' && top != '(') ||
                (ch == ']' && top != '[') ||
                (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}