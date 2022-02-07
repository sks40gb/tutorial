package programs.util;

public class MatrixUtil {

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            printArray(row);
            System.out.println("");
        }

    }

    public static void printArray(int[] arr){
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
