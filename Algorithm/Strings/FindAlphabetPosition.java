package Strings;

/**
 * Find the Alphabet position of English Letters
 */
public class FindAlphabetPosition {


    public static void main(String[] args) { 

        findAlphabetPosition("Algorithm");
    }

    static void findAlphabetPosition(String str) {

        for(char c: str.toCharArray()) {
            c = Character.toUpperCase(c);

            if(c >= 'A' || c <='Z') {
                System.out.println( " Character "+ c + " : " +  (c - 'A' + 1)); 
            }
            else {
                System.err.println(" Invalid Characters ");
            }
        }

    }
}