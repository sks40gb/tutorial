package algorithm.lcs;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "GeeksforGeeks";
        String s2 = "GeeksQuiz";
        int count = longestSubstring(s1.toCharArray(), s2.toCharArray());
        System.out.println(count);
    }

    private static int longestSubstring(char[] x, char[] y) {
        int[][] matrix = new int[x.length + 1][y.length + 1];
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == 0 || col == 0) {
                    matrix[row][col] = 0;
                }else if(x[row-1] == y[col-1]){
                    matrix[row][col] = matrix[row-1][col-1] + 1;
                    count = Math.max(count, matrix[row][col]);
                }
            }
        }
        return count;
    }
}
