package Strings;

/**
 * Two Numbers in String format is given, 
 * return the product of the two numbers 
 */
public class MultiplyNumberString{

    public static void main(String[] args) {
        
        System.out.println("Product of Two Number: " + findProductOfTwoNumber("1000", "10"));
    }

    static String findProductOfTwoNumber(String number1, String number2) {

        int n1 = number1.length();
        int n2 = number2.length();

        int[] result =  new int[n1+n2];

        for(int i= n1-1; i>=0; i--) {
            int d1 = number1.charAt(i) - '0'; 
            for(int j=n2-1; j>=0; j--) {
                int d2 = number2.charAt(j) -'0';

                int product = d1 * d2;
                int pos1 = i+j;
                int pos2 = i+j+1;

                int sum = product + result[pos2];
                result[pos1] += sum /10; //carry
                result[pos2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num: result) {
            if(sb.length() ==0 && num==0) continue;
            sb.append(num);
        }
        
        return sb.toString();
    }
    
}
