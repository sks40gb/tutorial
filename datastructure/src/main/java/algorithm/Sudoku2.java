package algorithm;

/**
 * https://leetcode.com/problems/sudoku-solver/
 */
public class Sudoku2 {

    public static void main(String[] args) {
        Sudoku2 sudoku = new Sudoku2();
        char[][] board =
            {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(sudoku.solve(board, 0, 0));
        sudoku.printBoard(board);
    }


    boolean solve(char[][] board, int i, int j) {

        if (i == 9) return true;
        if (j == 9) return solve(board, i + 1, 0);
        if (board[i][j] != '.') return solve(board, i, j + 1);

        for (char c = '1'; c <= '9'; c++) {
            if (isSafe(board, i, j, c)) {
                board[i][j] = c;
                if (solve(board, i, j + 1)) {
                    return true;
                } else {
                    board[i][j] = '.'; //backtrack
                }
            }
        }
        return false;
    }

    public boolean isSafe(char[][] board, int row, int col, char c) {

        for (int i = 0; i < board.length; i++) {

            if (board[row][i] == c) {
                return false;
            }

            if (board[i][col] == c) {
                return false;
            }

            int r1 = (row / 3) * 3 + i / 3;   //0,0,0 - 1,1,1 -2,2,2  - 123, 123
            int c1 = (col / 3) * 3 + i % 3;

            if (board[r1][c1] == c) {
                return false;
            }

        }
        return true;
    }

    public void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

}
