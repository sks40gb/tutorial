package algorithm.slidingwindow.variable;

import java.util.ArrayList;
import java.util.List;

/**
 * Longest Substring Without Repeating Characters
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println(findLongestString(input));
    }

    private static int findLongestString(String input){
        List<Character> list = new ArrayList<>();
        int leftIndex = 0;
        int longest = 0;
        for (int rightIndex = 0; rightIndex < input.length(); rightIndex++) {
            char c = input.charAt(rightIndex);
            if(!list.contains(c)){
                list.add(c);
                longest = Math.max(list.size(), longest);
            }else{
                while(list.contains(c)){
                    Character value = input.charAt(leftIndex);
                    list.remove(value);
                    leftIndex++;
                }
                list.add(c);
            }
        }
        return longest;
    }
}
