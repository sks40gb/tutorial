package algorithm.recursive;

import java.util.HashMap;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    Map<Integer, String> map;

    public LetterCombinationsOfPhoneNumber() {
        map = new HashMap<>();
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber l = new LetterCombinationsOfPhoneNumber();
        l.findLetters("245", "");
    }

    public void findLetters(String digit, String prefix) {
        if (digit.length() <= 0) {
            System.out.println(prefix);
            return;
        }

        String substring = digit.substring(1);
        Integer n = Integer.parseInt(String.valueOf(digit.charAt(0)));

        for (char c : map.get(n).toCharArray()) {
            findLetters(substring, prefix + c);
        }
    }
}
