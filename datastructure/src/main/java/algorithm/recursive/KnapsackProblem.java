package algorithm.recursive;

/**
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 *
 * Given weights and values of n items, put these items in a knapsack of
 * capacity W to get the maximum total value in the knapsack. In other words,
 * given two integer arrays val[0..n-1] and wt[0..n-1] which represent values
 * and weights associated with n items respectively. Also given an integer W
 * which represents knapsack capacity, find out the maximum value subset of
 * val[] such that sum of the weights of this subset is smaller than or equal to
 * W. You cannot break an item, either pick the complete item or don’t pick it
 * (0-1 property).
 *
 * Example :
 *
 * int val[] = new int[] { 60, 100, 120 };
 * int wt[] = new int[] { 10, 20, 30 };
 * int W = 50;
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        int[] val = new int[]{60, 100, 120};
        int[] wt = new int[]{10, 20, 30};
        int W = 40;
        System.out.println(knapSack(val, wt, W, 0, 0));
        System.out.println(knapSack2(val, wt, W, val.length));

    }

    /**
     * Recursive version 1
     */
    private static int knapSack(int[] val, int[] wt, int k, int index, int totalWeight) {

        if (index >= wt.length) {
            return 0;
        }

        if (wt[index] + totalWeight > k) {
            return knapSack(val, wt, k, index + 1, totalWeight);
        } else {
            int with = val[index] + knapSack(val, wt, k, index + 1, totalWeight + wt[index]);
            int without = knapSack(val, wt, k, index + 1, totalWeight);
            return Math.max(with, without);
        }
    }

    /**
     * Recursive Version 2 : This method can be turned into Tabulation (Bottom Up)
     */
    private static int knapSack2(int[] val, int[] wt, int W, int index) {
        if (index == 0 || W == 0) {
            return 0;
        }
        if (W - wt[index - 1] < 0) {
            return knapSack2(val, wt, W, index - 1);
        } else {
            int with = val[index - 1] + knapSack2(val, wt, W - wt[index - 1], index - 1);
            int without = knapSack2(val, wt, W, index - 1);
            return Math.max(with, without);
        }
    }

}
