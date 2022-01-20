package algorithm.recursive;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting
 * some or no elements without changing the order of the remaining elements. For
 * example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
 * length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] input = {4,10,4,3,8,9};
        System.out.println(findLongest(input, 0, Integer.MIN_VALUE));
        System.out.println(findLongestRecursively(input, input.length - 1, Integer.MAX_VALUE));
        System.out.println(findLongestIterative(input));
    }

    public static int findLongest(int[] input, int n, int prev) {

        if (n >= input.length) {
            return 0;
        }
        int take = 0;
        int dontTake = findLongest(input, n + 1, prev);
        if (input[n] > prev) {
            take = 1 + findLongest(input, n + 1, input[n]);
        }
        return Math.max(take, dontTake);
    }

    public static int findLongestRecursively(int[] input, int n, int next) {
        if (n <= -1) {
            return 0;
        }
        int take = 0;
        int dontTake = findLongestRecursively(input, n - 1, input[n]);
        if (next > input[n]) {
            take = 1 + findLongestRecursively(input, n - 1, input[n]);
        }
        return Math.max(take, dontTake);
    }


    public static int findLongestIterative(int[] input) {
        int n = input.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            int dontTake = dp[i];
            int take = 0;
            if(pre < input[i]){
                take = 1 + dp[i];
            }
            dp[i+1] = Math.max(take, dontTake);
            pre = input[i];
        }
        return dp[n];
    }


    public static int findLongestIterative2(int[] input) {
        int n = input.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        int next = Integer.MAX_VALUE;

        for (int i = input.length - 1; i > 0 ; i--) {
            int dontTake = dp[i-1];
            int take = 0;
            if(next > input[i]){
                take = 1 + dp[i-1];
            }
            dp[i] = Math.max(dontTake, take);
            next = input[i];
        }
        return dp[n];
    }

}
