package programs.array;

/*
 * http://collabedit.com/4htbj
 *
 * Given a n x n 2d array implement a method that rotate the object 90 degrees clockwise and print to console
 *
 * Example
 *
 * [1,2,3]
 * [4,5,6]
 * [7,8,9]
 *
 * rotate 90 degrees clockwise and print to console
 *
 * [7,4,1]
 * [8,5,2]
 * [9,6,3]
 *
 */
public class Rotate90Degree {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
        };
        for (int[] row : rotate(matrix)) {
            for (int v : row) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rotate(int[][] input) {
        int[][] output = new int[input.length][input.length];
        int l = input.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < input[i].length; j++) { // [1,2,3]
                int value = input[i][j];
                output[j][l - i - 1] = value;
            }
        }
        return output;
    }
    
    /**
     * Approach: We first transpose the given matrix, and then reverse the content
     * of individual rows to get the resultant 90 degree clockwise rotated matrix.
     */
    static void rotate90clockwise(int mat[][]) {

        int n = mat.length;
        // Transpose of matrix
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int t = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t;
            }

        // Reverse individual rows
        for (int i = 0; i < n; i++) {
            int low = 0, high = n - 1;
            while (low < high) {
                int t = mat[i][low];
                mat[i][low] = mat[i][high];
                mat[i][high] = t;
                low++;
                high--;
            }
        }
    }
}
