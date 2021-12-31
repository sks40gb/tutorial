package algorithm.recursive;

public class PermutationOfString {

    public static void main(String[] args) {
        String input = "abcd";
        new PermutationOfString().permutation(input, "");
    }

    private void permutation(String input, String permutation) {

        if (input.length() == 0) {
            System.out.println(permutation);
        }

        for (int i = 0; i < input.length(); i++) {
            String exclusiveString = getExclusiveString(input, i);
            permutation(exclusiveString, permutation + input.charAt(i));
        }
    }

    private String getExclusiveString(String input, int index) {
        return input.substring(0, index) + input.substring(index + 1);
    }
}
