package algorithm.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/find-possible-words-phone-digits/
 */
public class PrintKeypadCombination {

    public static String keypad[] = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs",
        "tu", "vwx", "yz"};

    public static void main(String[] args) {
        PrintKeypadCombination l = new PrintKeypadCombination();
        System.out.println(l.solution1("123", ""));
        System.out.println("----------------");
        solution2("23", 0, "");
    }

    public List<String> solution1(String digit, String prefix) {
        List<String> l = new ArrayList<>();

        if (digit.length() <= 0) {
            l.add(prefix);
            return l;
        }

        String substring = digit.substring(1);
        for (char c : keypad[digit.charAt(0) - '0'].toCharArray()) {
            l.addAll(solution1(substring, prefix + c));
        }
        return l;
    }


    public static void solution2(String number, int idx, String res) {
        if (idx == number.length()) {
            System.out.println(res);
            return;
        }
        for (int i = 0; i < keypad[number.charAt(idx) - '0'].length(); i++) {
            char curr = keypad[number.charAt(idx) - '0'].charAt(i);
            solution2(number, idx + 1, res + curr);
        }
    }
}
