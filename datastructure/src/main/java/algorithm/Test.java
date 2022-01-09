package algorithm;

public class Test {

    public static void main(String[] args) {
        int[][] board = new int[4][4];
        System.out.println(solve(board, 4));
        printBoard(board);
    }

    private static boolean solve(int[][] board, int k) {
        int length = board.length;
        for (int r = 0; r < length; r++) {
            for (int c = 0; c < length; c++) {
                if (placeQueen(board, r, c, k)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(" " + board[row][col]);
            }
            System.out.println("");
        }
    }

    private static boolean placeQueen(int[][] board, int row, int col, int k) {

        int length = board.length;

        if (k == 0) {
            return true;
        }

        if (col >= length) {
            row++;
            col = 0;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = -1;
            if (placeQueen(board, row, col + 1, k - 1)) {
                return true;
            } else {
                board[row][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        if(row >= board.length || col >= board.length){
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == -1 || board[i][col] == -1) {
                return false;
            }
        }

        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][r] == -1) {
                return false;
            }
        }


        for (int r = row, c = col; r < board.length && c < board.length; r++, c++) {
            if (board[r][r] == -1) {
                return false;
            }
        }

        for (int r = row, c = col; r < board.length && c >= 0; r++, c--) {
            if (board[r][r] == -1) {
                return false;
            }
        }

        for (int r = row, c = col; r >= 0 && c < board.length; r--, c++) {
            if (board[r][r] == -1) {
                return false;
            }
        }
        return true;
    }


}
