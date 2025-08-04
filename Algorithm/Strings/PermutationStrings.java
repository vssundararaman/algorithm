package Strings;

public class PermutationStrings {
    
    public static void main(String[] args) {
        String string = "abc";
        permutation(string, "");
    }

    public static void permutation(String input, String output) {

        if(input.length() == 0) {
            System.out.print (output + " ");
        }

        for(int i=0; i<input.length(); i++) {
            char currentChar = input.charAt(i);
            String rem = input.substring(0,i)+input.substring(i+1);
            permutation(rem, output+currentChar);
        }
    }
}
