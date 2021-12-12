package algorithm.recursive;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 *
 * Given a value N, if we want to make change for N cents, and we have infinite supply of
 * each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change?
 * The order of coins doesn’t matter.
 *
 * For example, for N = 4 and S = {1,2,3},
 * there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 6};
        int k = 10;
        System.out.println("--- count-----");
        System.out.println(solution1(arr, arr.length, 10));
        System.out.println("--- count-----");
        System.out.println(solution2(arr, arr.length, 10));
        System.out.println("----- set -----");
        solution4(arr, k, 0, "", 0);
    }

    /**
     * Output : 5
     */
    static int solution1(int arr[], int index, int k) {

        if (k == 0) {
            return 1;
        }

        if (k < 0) {
            return 0;
        }

        if (index <= 0 && k >= 1) {
            return 0;
        }

        // count is sum of solutions (i)
        // including arr[index-1] (ii) excluding arr[index-1]
        return solution1(arr, index - 1, k) +
            solution1(arr, index, k - arr[index - 1]);
    }

    static long solution2(int arr[], int index, int k) {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)
        long[] table = new long[k + 1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;
        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 0; i < index; i++){
            for (int j = arr[i]; j <= k; j++){
                table[j] += table[j - arr[i]];
            }
        }

        return table[k];
    }


    /**
     * Output
     * ----------------------
     * 22222
     * 2233
     * 226
     * 253
     * 55
     */
    private static void solution4(int[] coins, int k, int sum, String result, int index) {
        if (index >= coins.length) {
            return;
        }
        if (sum == k) {
            System.out.println(result);
            return;
        } else if (sum > k) {
            return;
        }
        solution4(coins, k, sum + coins[index], result + coins[index], index);
        solution4(coins, k, sum, result, index + 1);
    }


}
