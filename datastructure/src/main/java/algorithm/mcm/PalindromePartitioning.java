package algorithm.mcm;

/**
 * https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/
 * Given a string, a partitioning of the string is a palindrome partitioning if every
 * substring of the partition is a palindrome.
 *
 * For example, “aba|b|bbabb|a|b|aba”
 * is a palindrome partitioning of “ababbbabbababa”.
 */
public class PalindromePartitioning {

    public static void main(String args[]) {
        String str = "ababbbabbababa";
        System.out.println("Min cuts needed for "
            + "Palindrome Partitioning is " + minPartition(str, 0, str.length() - 1));
    }

    static boolean isPalindrome(String string, int i, int j) {
        while (i < j) {
            if (string.charAt(i) != string.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static int minPartition(String string, int i, int j) {
        if (i >= j || isPalindrome(string, i, j))
            return 0;
        int ans = Integer.MAX_VALUE, count;
        for (int k = i; k < j; k++) {
            count = minPartition(string, i, k) + minPartition(string, k + 1, j) + 1;
            ans = Math.min(ans, count);
        }
        return ans;
    }

}
