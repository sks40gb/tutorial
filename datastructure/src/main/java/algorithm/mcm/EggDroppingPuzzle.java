package algorithm.mcm;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
 *
 * eggDrop(n, k) = 1 + min{max(eggDrop(n – 1, x – 1), eggDrop(n, k – x)), where x is in {1, 2, …, k}}
 */
public class EggDroppingPuzzle {

    public static void main(String[] args) {
        System.out.println(eggDrop(2, 10)); //output : 4
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
            int res = Math.max(eggDrop(eggs - 1, k - 1), eggDrop(eggs, floors - k));
            min = Math.min(res, min);
        }
        dp[eggs][floors] = min + 1;
        return dp[eggs][floors];
    }

}
