package Numbers;

public class PermuatationNumbers {
    public static void main(String[] args) {
        int n = 123;
        int[] digits = getDigits(n);
        generatePermutations(digits, 0, digits.length - 1);
    }

    private static void generatePermutations(int[] arr, int start, int end) {
        if (start == end) {
            printArray(arr);
            return;
        }

        for (int i = start; i <= end; i++) {
            swap(arr, start, i);
            generatePermutations(arr, start + 1, end);
            swap(arr, start, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num);
        }
        System.out.println();
    }

    private static int[] getDigits(int n) {
        String numStr = String.valueOf(n);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }


}
