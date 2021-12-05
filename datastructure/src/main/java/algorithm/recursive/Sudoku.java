package algorithm.recursive;

public class Sudoku {

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
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

        System.out.println(sudoku.solve(board));
        sudoku.printBoard(board);
    }

    public boolean solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isFilled(board, i, j)) {
                    continue;
                }
                for (char c = '1'; c <= '9'; c++) {
                    if (isSafe(board, i, j, c)) {
                        board[i][j] = c;
                        if (solve(board)) {
                            return true;
                        } else {
                            board[i][j] = '.';
                        }
                    }
                    return  false;
                }

            }
        }
        return true;
    }

    private boolean isFilled(char[][] board, int i, int j) {
        return board[i][j] != '.';
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

    public boolean isSolved(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
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
