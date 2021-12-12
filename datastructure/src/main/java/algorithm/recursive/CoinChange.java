package algorithm.recursive;

/**
 * https://www.geeksforgeeks.org/coin-change-dp-7/
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 6};
        int k = 10;
        solution1(arr, k, 0, "", 0);
        System.out.println("--- count-----");
        System.out.println(solution2(arr, k, 0, 0));
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
    private static void solution1(int[] coins, int k, int sum, String result, int index) {
        if (index >= coins.length) {
            return;
        }
        if (sum == k) {
            System.out.println(result);
            return;
        } else if (sum > k) {
            return;
        }
        solution1(coins, k, sum + coins[index], result + coins[index], index);
        solution1(coins, k, sum, result, index + 1);
    }

    /**
     * Output : 5
     */
    private static int solution2(int[] coins, int k, int sum, int index) {
        if (index >= coins.length) {
            return 0;
        }
        if (sum == k) {
            return 1;
        } else if (sum > k) {
            return 0;
        }
        return solution2(coins, k, sum + coins[index], index) + solution2(coins, k, sum, index + 1);
    }

}
