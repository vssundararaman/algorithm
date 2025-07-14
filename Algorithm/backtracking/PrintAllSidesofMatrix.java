package backtracking;

public class PrintAllSidesofMatrix {

    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        printAllSides(matrix);
    }

    static void printAllSides(int[][] matrix) {

        // print Matrix as Such

        for(int[] row: matrix) {
            for (int cell: row) {
                System.out.print(cell + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
}
