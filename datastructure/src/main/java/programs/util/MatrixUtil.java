package programs.util;

public class MatrixUtil {

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println("");
        }

    }
}
