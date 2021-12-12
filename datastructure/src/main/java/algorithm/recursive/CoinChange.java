package algorithm.recursive;

/**
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 6};
        int k = 10;
        System.out.println("--- count-----");
        System.out.println(solution1(arr, arr.length, 10));
        System.out.println("----- set -----");
        solution2(arr, k, 0, "", 0);
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

    /**
     * Output
     * ----------------------
     * 22222
     * 2233
     * 226
     * 253
     * 55
     */
    private static void solution2(int[] coins, int k, int sum, String result, int index) {
        if (index >= coins.length) {
            return;
        }
        if (sum == k) {
            System.out.println(result);
            return;
        } else if (sum > k) {
            return;
        }
        solution2(coins, k, sum + coins[index], result + coins[index], index);
        solution2(coins, k, sum, result, index + 1);
    }


}
