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
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] input = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(findLongest(input, 0, Integer.MIN_VALUE));
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


}
