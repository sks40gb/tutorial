package algorithm;

public class Test {
    public static void main(String[] args) {

        int n = 4;
        int[][] board = new int[n][n];
        System.out.println(solved(board));
        print(board);
    }

    private static boolean solved(int[][] board) {

        int queens = board.length;
        return queenPlaced(board, 0, queens);

    }

    private static boolean queenPlaced(int[][] board, int row, int queens) {
        if (row >= board.length) {
            return false;
        }
        if (queens == 0) {
            return true;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;
                if (queenPlaced(board, row + 1, queens - 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {

        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 1 || board[i][col] == 1) {
                return false;
            }
        }

        for (int i = 0, j = 0; i < row && j < col; i++, j++) {
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
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}
