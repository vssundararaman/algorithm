package javaswing;

import javax.swing.*;
import java.awt.*;

public class NQueensGUI extends JPanel {

    private final int N;
    private int[][] board;

    public NQueensGUI(int N) {
        this.N = N;
        board = new int[N][N];
        solveNQueens(board, 0);
        setPreferredSize(new Dimension(N * 60, N * 60));
    }

    // Solve N-Queens using backtracking
    boolean solveNQueens(int[][] board, int row) {
        if (row == N)
            return true;

        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;

                if (solveNQueens(board, row + 1))
                    return true;

                board[row][col] = 0; // backtrack
            }
        }
        return false;
    }

    // Check if placing queen is safe
    boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = row, j = col; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Draw the chessboard and queens
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int squareSize = getWidth() / N;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                boolean isWhite = (row + col) % 2 == 0;
                g.setColor(isWhite ? Color.WHITE : Color.GRAY);
                g.fillRect(col * squareSize, row * squareSize, squareSize, squareSize);

                if (board[row][col] == 1) {
                    g.setColor(Color.RED);
                    g.setFont(new Font("Arial", Font.BOLD, squareSize / 2));
                    g.drawString("Q", col * squareSize + squareSize / 3, row * squareSize + 2 * squareSize / 3);
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 8; // Change this for other board sizes

        JFrame frame = new JFrame("N-Queens Problem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new NQueensGUI(N));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}