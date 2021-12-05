package algorithm.slidingwindow.fixed;

import java.util.Arrays;

/**
 * Count Occurrences of Anagrams
 * <p>
 * Input : forxxorfxdofr
 * for
 * Output : 3
 * Explanation : Anagrams of the word for - for, orf,
 * ofr appear in the text and hence the count is 3.
 * <p>
 * <p>
 * Input : aabaabaa
 * aaba
 * Output : 4
 * Explanation : Anagrams of the word aaba - aaba,
 * abaa each appear twice in the text and hence the
 * count is 4.
 */
public class CountOccurrencesOfAnagrams {
    public static void main(String[] args) {
        String input = "aabaabaa";
        String match = "aaba";
        int count = countAnagrams(input, match);
        System.out.println(count);
    }

    private static int countAnagrams(String input, String match) {
        if (input.length() < match.length()) {
            return 0;
        }
        int CHARACTERS = 256;
        int[] inputArray = new int[CHARACTERS];
        int[] matchArray = new int[CHARACTERS];

        for (char c : match.toCharArray()) {
            matchArray[c]++;
        }

        int occurrence = 0;
        int k = match.length();
        for (int i = 0; i < k; i++) {
            inputArray[input.charAt(i)]++;
        }
        if (Arrays.equals(inputArray, matchArray)) {
            occurrence++;
        }
        for (int i = k; i < input.length(); i++) {
            inputArray[input.charAt(i - k)]--;
            inputArray[input.charAt(i)]++;
            if (Arrays.equals(inputArray, matchArray)) {
                occurrence++;
            }
        }
        return occurrence;
    }
}





