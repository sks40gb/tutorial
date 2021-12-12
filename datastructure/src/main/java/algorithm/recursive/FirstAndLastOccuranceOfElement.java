package algorithm.recursive;

public class FirstAndLastOccuranceOfElement {

    public static void main(String[] args) {
        String s = "abaacdaefaah";
        char k = 'a';
        findFirstAndLastOccurance(s, k, -1, -1, 0);
    }

    private static void findFirstAndLastOccurance(String input, char k, int firstIndex, int lastIndex, int index) {
        if (index >= input.length()) {
            System.out.println("FirstIndex " + firstIndex + " and lastIndex = " + lastIndex);
            return;
        }
        if (input.charAt(index) == k) {
            if (firstIndex == -1) {
                firstIndex = index;
            }
            lastIndex = index;
        }
        findFirstAndLastOccurance(input, k, firstIndex, lastIndex, index + 1);
    }
}
