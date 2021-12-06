package algorithm.recursive;

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
        System.out.println(findWays(input, ""));
        System.out.println(anotherQuickSolution(input.length()));
    }

    public static int findWays(String input, String output) {
        if (input.length() == 0) {
            System.out.println("output : " + output);
            return 1;
        }
        char c = input.charAt(0);
        String str = removeChar(input, 0);
        int count = 0;
        count = count + findWays(str, output + "[" + c + "]");
        for (int i = 0; i < str.length(); i++) {
            char c2 = str.charAt(i);
            String newInput = removeChar(str, i);
            count = count + findWays(newInput, output + "[" + c + "," + c2 + "]");
        }
        return count;
    }

    private static String removeChar(String input, int index) {
        return input.substring(0, index) + input.substring(index + 1);
    }

    public static int anotherQuickSolution(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return anotherQuickSolution(n - 1) + (n - 1) * anotherQuickSolution(n - 2);
    }
}
