package algorithm.recursive;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/count-ways-reach-nth-stair-using-step-1-2-3/
 *
 * A child is running up a staircase with n steps and can hop either 1 step, 2
 * steps, or 3 steps at a time. Implement a method to count how many possible
 * ways the child can run up the stairs.
 *
 * Input : 3
 * Output : 4
 * Explanation:
 * Below are the four ways
 * 1 step + 1 step + 1 step
 * 1 step + 2 step
 * 2 step + 1 step
 * 3 step
 */
public class CountWaysToNthStair {

    public static void main(String args[]) {
        int n = 12;
        System.out.println(findWaysRecursive(n));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(findWaysRecursiveDP(n, dp));
        System.out.println(countWaysIterativeDP(n));
    }


    private static int findWaysRecursive(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return findWaysRecursive(n - 1) + findWaysRecursive(n - 2) + findWaysRecursive(n - 3);
    }

    private static int findWaysRecursiveDP(int n, int[] dp) {
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return dp[n] = findWaysRecursiveDP(n - 1, dp) + findWaysRecursiveDP(n - 2, dp) + findWaysRecursiveDP(n - 3, dp);
    }

    public static int countWaysIterativeDP(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++)
            res[i] = res[i - 1] + res[i - 2] + res[i - 3];

        return res[n];
    }


}
