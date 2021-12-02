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
            for (int j = 0; j < input[i].length; j++) {  // [1,2,3]
                int v = input[i][j];
                output[j][l - i - 1] = v;
            }
        }
        return output;
    }
}
