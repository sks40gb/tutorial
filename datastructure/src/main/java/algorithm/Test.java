package algorithm;

public class Test {
    public static void main(String[] args) {

        int n = 4;
        int[][] board = new int[n][n];
        System.out.println(queenPlaced(board, 0, n));
        print(board);
    }

    private static boolean queenPlaced(int[][] board, int row, int k) {
        if (k == 0) {
            return true;
        }
        for (int i = row; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (isSafe(board, i, j)) {
                    board[i][j] = 1;
                    if (queenPlaced(board, row + 1, k - 1)) {
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
