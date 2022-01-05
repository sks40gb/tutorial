package algorithm.recursive.latest;

/**
 * https://leetcode.com/problems/house-robber/
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
 * can rob tonight without alerting the police.
 *
 * Example
 * ------------
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] input = {2, 7, 9}; // 12
        System.out.println(rob(input, 0));
        System.out.println(rob2(input, input.length - 1));
        System.out.println(robDP(input));
    }

    // Recursive method 1
    public static int rob(int[] input, int index) {
        if (index == input.length - 1) {
            return input[index];
        }
        if (index >= input.length) {
            return 0;
        }
        int robIt = input[index] + rob(input, index + 2);
        int dontRobIt = rob(input, index + 1);
        return Math.max(robIt, dontRobIt);
    }

    // Recursive method 2
    public static int rob2(int[] input, int index) {
        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return input[0];
        }
        int robIt = input[index] + rob2(input, index - 2);
        int skipIt = rob2(input, index - 1);
        return Math.max(robIt, skipIt);
    }

    // DP method -> similar to Recursive method 2.
    // Actually recursive method 2 was created
    // to build DP solution below.
    public static int robDP(int[] nums) {
        int n = nums.length - 1;
        int[] dp = new int[n + 1];
        if (nums.length == 1) {
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i <= n; i++) {
            int robeIt = nums[i] + dp[i - 2];
            int skipIt = dp[i - 1];
            dp[i] = Math.max(robeIt, skipIt);
        }
        return dp[n];
    }

}

