package algorithm.recursive;

import java.util.Arrays;

/***
 * Friend either they can go alone or in pair.
 * Find the number of ways they can go.
 *
 * Ex : 1 person A can go only 1 way
 *      2 person AB can go alone A & B or AB together
 */
public class FriendsPartyPlan {


    public static void main(String[] args) {
        String input = "ABCDEFGH";
        System.out.println(findWays1(input, ""));
        System.out.println(findWays2(input.length()));

        int[] dp = new int[input.length() + 1];
        Arrays.fill(dp, -1);
        System.out.println("With dynamic programming :  " + findWays3(input.length(), dp));
        System.out.println(findWays4(input.length()));
    }

    /**
     * Not a actual solution but to explain the recursion.
     */
    public static int findWays1(String input, String output) {
        if (input.length() == 0) {
            System.out.println("output : " + output);
            return 1;
        }
        char c = input.charAt(0);
        String subString = removeChar(input, 0);

        int count = findWays1(subString, output + "[" + c + "]");

        for (int i = 0; i < subString.length(); i++) {
            char c2 = subString.charAt(i);
            String newInput = removeChar(subString, i);
            count = count + findWays1(newInput, output + "[" + c + "," + c2 + "]");
        }
        return count;
    }

    private static String removeChar(String input, int index) {
        return input.substring(0, index) + input.substring(index + 1);
    }

    /**
     * Simple Solution
     */
    public static int findWays2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return findWays2(n - 1) + (n - 1) * findWays2(n - 2);
    }

    /**
     * Iterative
     */
    public static int findWays4(int n){
        int[] res = new int[n+1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n ; i++) {
            res[i] = res[i-1] + (i-1) * res[i-2];
        }
        return res[n];
    }

    /**
     * Using Dynamic Programming
     */
    private static int findWays3(int n, int[] dp) {
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n == 1 || n == 2) {
            return n;
        }
        dp[n] = findWays2(n - 1) + (n - 1) * findWays2(n - 2);
        return dp[n];
    }
}
