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
        System.out.println(knapSack(W, val, wt, val.length));

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
    static int knapSack(int W, int wt[], int val[], int n) {
        if (n == 0 || W == 0)
            return 0;

        if (wt[n - 1] > W) {
            return knapSack(W, wt, val, n - 1);

        } else {
            return Math.max(
                val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                knapSack(W, wt, val, n - 1)
            );

        }
    }

    /**
     * Iterative version of above format
     */
    int knapSackDP(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    K[i][w] = Math.max(
                        val[i - 1] + K[i - 1][w - wt[i - 1]],
                        K[i - 1][w]
                    );
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }
        return K[n][W];
    }


}
