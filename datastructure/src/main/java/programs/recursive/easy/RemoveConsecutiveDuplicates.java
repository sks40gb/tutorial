package programs.recursive.easy;

public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeConsecutiveDuplicates("aazbbby"));
    }

    public static String removeConsecutiveDuplicates(String s) {
        return removeDuplicate(s, "", 0);
    }

    private static String removeDuplicate(String input, String acc, int index) {
        if (index >= input.length()) {
            return "";
        }
        char c = input.charAt(index);

        if (isLastCharMatching(acc, c)) {
           return removeDuplicate(input, acc, index+1);
        }else{
            return c + removeDuplicate(input, acc + input.charAt(index), index+1);
        }
    }

    private static boolean isLastCharMatching(String acc, char c) {
        return acc.length() > 0 && acc.charAt(acc.length() - 1) == c;
    }

}
