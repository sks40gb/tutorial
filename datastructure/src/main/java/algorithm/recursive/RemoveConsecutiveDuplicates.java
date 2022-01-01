package algorithm.recursive;

/**
 * https://www.geeksforgeeks.org/remove-consecutive-duplicates-string/
 * 
 * Given a string S, remove all the consecutive duplicates. Note that this
 * problem is different from Recursively remove all adjacent duplicates. Here we
 * keep one character and remove all subsequent same characters.
 * 
 * Input : aaaaabbbbbb
 * Output : ab
 * 
 * Input : geeksforgeeks
 * Output : geksforgeks
 * 
 * Input : aabccba
 * Output : abcba
 */
public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeConsecutiveDuplicates("aazbbby"));
    }

    public static String removeConsecutiveDuplicates(String s) {
        return removeDuplicate(s, 0, null);
    }

    private static String removeDuplicate(String input, int index, Character lastChar) {
        if (index >= input.length()) {
            return "";
        }
        char c = input.charAt(index);
        index++;

        if (lastChar != null && c == lastChar) {
            return removeDuplicate(input, index, lastChar);
        } else {
            return c + removeDuplicate(input, index, c);
        }
    }

}
