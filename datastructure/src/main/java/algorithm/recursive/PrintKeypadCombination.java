package algorithm.recursive;

import java.util.ArrayList;
import java.util.List;

public class PrintKeypadCombination {

    public static void main(String[] args) {
        String[] keypad = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        PrintKeypadCombination l = new PrintKeypadCombination();
        System.out.println(l.findLetters(keypad, "123", ""));
    }

    public List<String> findLetters(String[] keypad, String digit, String prefix) {
        List<String> l = new ArrayList<>();

        if (digit.length() <= 0) {
            l.add(prefix);
            return l;
        }

        String substring = digit.substring(1);
        for (char c : keypad[digit.charAt(0) - '0'].toCharArray()) {
            l.addAll(findLetters(keypad, substring, prefix + c));
        }
        return l;
    }
}
