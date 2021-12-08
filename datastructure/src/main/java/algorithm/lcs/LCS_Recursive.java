package algorithm.lcs;

/**
 *
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 *
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class LCS_Recursive {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(new LCS_Recursive().lcs(s1, s2, s1.length(), s2.length()));
    }

    public int lcs(String s1, String s2, int length1, int length2) {

        if (length1 == 0 || length2 == 0) {
            return 0;
        }
        int count = 0;
        if (s1.charAt(length1 - 1) == s2.charAt(length2 - 1)) {
            count = 1 + lcs(s1, s2, length1 - 1, length2 - 1);
        } else {
            count = Math.max(lcs(s1, s2, length1 - 1, length2), lcs(s1, s2, length1, length2 - 1));
        }
        return count;
    }
}
