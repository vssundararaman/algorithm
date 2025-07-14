package backtracking;

public class NQueen {

    final int N;

    public NQueen(int n) {
        N = n;
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen(8);
        nQueen.solve();
    }

    void solve() {
        //Declare board
        int[][] board = new int[N][N];
        printSolution(board);
        if (!solveNQueen(board, 0)) {
            System.out.println("Solution does not exist");
        }
    }

    boolean solveNQueen(int[][] board, int row) {

        if (row == N) {
            printSolution(board);
            return true;
        }
        boolean result = false;

        for (int col = 0; col < N; col++) {

            if (isSafe(board, row, col)) {
                board[row][col] = 1;

                result = solveNQueen(board, row + 1) || result;

                board[row][col] = 0;
            }
        }


        return result;
    }

    private boolean isSafe(int[][] board, int row, int col) {

        // check the column in upper side
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        return true;
    }

    private void printSolution(int[][] board) {

        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
}
