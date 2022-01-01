package algorithm.recursive;

/**
 * https://www.geeksforgeeks.org/remove-duplicates-from-a-given-string/
 * 
 * Given a string S, the task is to remove all the duplicates in the given
 * string.
 * Below are the different methods to remove duplicates in a string.
 * 
 */
public class RemoveDuplicatesFromString {

    public static void main(String args[]) {
        String str = "abcadbcefghabi";
        boolean present[] = new boolean[str.length()];
        System.out.println(removeDuplicates(str, 0, present));
    }

    public static String removeDuplicates(String str, int idx, boolean present[]) {
        if (idx == str.length()) {
            return "";
        }
        char curr = str.charAt(idx);
        if (present[curr - 'a']) {
            return removeDuplicates(str, idx + 1, present);
        } else {
            present[curr - 'a'] = true;
            return curr + removeDuplicates(str, idx + 1, present);
        }
    }

}
