package algorithm.lcs;

/**
 * Input : AGGTAB GXTXAYB
 * Output : 4
 */
public class LCS_Top_Down {

    public static void main(String[] args) {
        LCS_Top_Down lcs = new LCS_Top_Down();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        System.out.println("Length of LCS is" + " " + lcs.lcs(x, y));
    }

    private int lcs(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;
        int[][] matrix = new int[m + 1][n + 1];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == 0 || col == 0) {
                    matrix[row][col] = 0;
                } else if (x[row - 1] == y[col - 1]) {
                    matrix[row][col] = matrix[row - 1][col - 1] + 1;
                } else {
                    matrix[row][col] = Math.max(matrix[row - 1][col], matrix[row][col - 1]);
                }
            }
        }
        return matrix[m][n];
    }

}


