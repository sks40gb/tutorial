package algorithm;

public class Test {

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 0, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 1, 0}
        };
        System.out.println(solve(matrix, 0, 0, 1));
    }

    private static boolean solve(int[][] matrix, int row, int col, int n) {

        if (row < 0
            || col < 0 //not beyond top
            || row >= matrix.length // not row to the left
            || col >= matrix[0].length
            || matrix[row][col] == -1
            || (matrix[row][col] == 1 && n == 0)) {
            return false;
        }

        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            System.out.println("found " + row + "," + col + " v :" + matrix[row][col]);
            return true;

        }

        System.out.println(row + "," + col + " v: " + matrix[row][col]);

        int preValue = matrix[row][col];
        if (matrix[row][col] == 1) {
            n--;
        }

        matrix[row][col] = -1;
        System.out.println(" starting from " + row + "," + col);

        int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int d = 0; d < DIRECTIONS.length; d++) {
            if (solve(matrix, row + DIRECTIONS[d][0], col + DIRECTIONS[d][1], n)) {
                return true;
            }
        }
        matrix[row][col] = preValue;

        return false;
    }


}
