package algorithm.recursive;

/**
 * https://leetcode.com/problems/k-th-symbol-in-grammar/
 */
public class KthSymbolInGrammar {

    public static void main(String[] args) {
        int n = 2;
        int k = 2;
        System.out.println(kthGrammar(n, k));
    }

    public static int kthGrammar(int n, int k) {
        int[][] matrix = new int[n+1][];
        matrix[0] = new int[1];
        return findKth(matrix, n, k);
    }

    public static int findKth(int[][] arr, int n, int k) {
        int currentRow = arr.length - n - 1;
        if (currentRow >= arr.length) {
            return arr[n + 1][k];
        } else {
            arr[currentRow + 1] = new int[arr[currentRow].length * 2];

            int[] row = arr[currentRow];
            int[] nextRow = arr[currentRow + 1];

            for (int i = 0, j = 0; i < row.length; i++) {
                int value = row[i];
                if (value == 0) {
                    nextRow[j] = 0;
                    nextRow[j + 1] = 1;
                } else if (value == 1) {
                    nextRow[j] = 0;
                    nextRow[j + 1] = 1;
                }
                j += 2;
            }
            return findKth(arr, n - 1, k);
        }
    }
    
    public int kthGrammar2(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int parent = kthGrammar(n - 1, (k + 1) / 2);
        if (k % 2 == 0) {
            return parent == 1 ? 0 : 1;
        } else {
            return parent;
        }
    }
}





