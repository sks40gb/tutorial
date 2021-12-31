package algorithm.mcm;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
 *
 * eggDrop(n, k) = 1 + min{max(eggDrop(n – 1, x – 1), eggDrop(n, k – x)), where x is in {1, 2, …, k}}
 */
public class EggDroppingPuzzle {

    public static void main(String[] args) {
        int eggs = 2;
        int floors = 10;
        int[][] dp = new int[eggs+1][floors+1];
        for (int egg = 0; egg < dp.length; egg++) {
            Arrays.fill(dp[egg], -1);
        }
        System.out.println(eggDrop3(eggs, floors)); //output : 4
        System.out.println(eggDropDP(eggs, floors, dp)); //output : 4
        System.out.println(eggDrop(eggs, floors)); //output : 4
    }

    private static int eggDrop(int eggs, int floors) {

        if (floors == 0 || floors == 1 || eggs == 1) {
            return floors;
        }

        int min = Integer.MAX_VALUE;

        for (int k = 1; k <= floors; k++) {
            int res = Math.max(eggDrop(eggs - 1, k - 1), eggDrop(eggs, floors - k));
            min = Math.min(res, min);
        }
        return min + 1;
    }

    private static int eggDropDP(int eggs, int floors, int[][] dp) {

        if (dp[eggs][floors] != -1) {
            System.out.println("from mem");
            return dp[eggs][floors];
        }

        if (floors == 0 || floors == 1 || eggs == 1) {
            return floors;
        }

        int min = Integer.MAX_VALUE;

        for (int k = 1; k <= floors; k++) {
            int res = Math.max(eggDropDP(eggs - 1, k - 1, dp), eggDropDP(eggs, floors - k, dp));
            min = Math.min(res, min);
        }
        dp[eggs][floors] = min + 1;
        return dp[eggs][floors];
    }

    static int eggDrop3(int n, int k) {
        /* A 2D table where entry eggFloor[i][j]
 will represent minimum number of trials
needed for i eggs and j floors. */
        int eggFloor[][] = new int[n + 1][k + 1];
        int res;
        int i, j, x;

        // We need one trial for one floor and
        // 0 trials for 0 floors
        for (i = 1; i <= n; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        // We always need j trials for one egg
        // and j floors.
        for (j = 1; j <= k; j++)
            eggFloor[1][j] = j;

        // Fill rest of the entries in table using
        // optimal substructure property
        for (i = 2; i <= n; i++) {
            for (j = 2; j <= k; j++) {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++) {
                    res = 1 + Math.max(
                        eggFloor[i - 1][x - 1],
                        eggFloor[i][j - x]);
                    if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }

        // eggFloor[n][k] holds the result
        return eggFloor[n][k];
    }

}
