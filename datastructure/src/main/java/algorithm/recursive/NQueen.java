package algorithm.recursive;

/**
 * https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/
 *
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so
 * that no two queens attack each other. For example, following is a solution
 * for 4 Queen problem.
 */
public class NQueen {
    public static void main(String[] args) {

        int n = 8;
        int[][] board = new int[n][n];
        int row = 0;
        System.out.println(queenPlaced(board, row));
        print(board);
    }

    /**
     * Solution 1
     *
     * Check each row
     */
    private static boolean queenPlaced(int[][] board, int row) {

        //means all queens are placed successfully.
        if (row >= board.length) {
            return true;
        }
        //check in all columns for row
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                if (queenPlaced(board, row + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    /**
     * Solution 2
     * Another simple version of solution 1
     */
    private static boolean queenPlaced2(int[][] board, int row, int k) {
        if (k == 0) {
            return true;
        }
        for (int i = row; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (isSafe(board, i, j)) {
                    board[i][j] = 1;
                    if (queenPlaced2(board, row + 1, k - 1)) {
                        return true;
                    }
                    board[i][j] = 0;
                }
            }

            // If queen cannot be placed in row,
            // no need to iterate to next row
            return false;
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {

        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 1 || board[i][col] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
