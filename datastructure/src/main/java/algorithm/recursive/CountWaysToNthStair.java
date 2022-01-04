package algorithm.recursive;

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
        int n = 4;
        System.out.println(findStepRecursive(n));
    }

    public static int findStepRecursive(int n) {
        if (n == 0) {

            return 0;
        } else if (n < 0) {
            return 0;
        } else {
            return findStepRecursive(n - 3) + findStepRecursive(n - 2)
                + findStepRecursive(n - 1);
        }
    }

    public static int countWaysIterative(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;

        for (int i = 3; i <= n; i++)
            res[i] = res[i - 1] + res[i - 2] + res[i - 3];

        return res[n];
    }


}
