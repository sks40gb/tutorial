package programs.array.print;

/**
 * Print
 *
 *      ⦿
 *      ⦿⦿
 *      ⦿⦿⦿
 *      ⦿⦿⦿⦿
 *      ⦿⦿⦿⦿⦿
 *
 */
public class Triangle {

    public static void main(String[] args) {
        char[][] matrix = new char[5][5];
        printTriangle(matrix);
    }


    private static void printTriangle(char[][] matrix) {
        int n = matrix.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("⦿");
            }
            System.out.println();
        }
    }


}
