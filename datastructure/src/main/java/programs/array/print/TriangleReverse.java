package programs.array.print;

/**
 * Print below pattern
 * ------------------------
 *          ⦿⦿⦿⦿⦿
 *          ⦿⦿⦿⦿
 *          ⦿⦿⦿
 *          ⦿⦿
 *          ⦿
 */
public class TriangleReverse {

    public static void main(String[] args) {
        char[][] matrix = new char[5][5];
        printTriangle(matrix);
    }

    private static void printTriangle(char[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("⦿");
            }
            System.out.println();
        }
    }

}
