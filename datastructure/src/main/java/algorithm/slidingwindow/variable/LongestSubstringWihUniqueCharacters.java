package algorithm.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the longest substring with k unique characters in a given string
 * Examples :
 *
 * "aabbcc", k = 1
 * Max substring can be any one from {"aa" , "bb" , "cc"}.
 *
 * "aabbcc", k = 2
 * Max substring can be any one from {"aabb" , "bbcc"}.
 *
 * "aabbcc", k = 3
 * There are substrings with exactly 3 unique characters
 * {"aabbcc" , "abbcc" , "aabbc" , "abbc" }
 * Max is "aabbcc" with length 6.
 *
 * "aaabbb", k = 3
 * There are only two unique characters, thus show error message.
 */
public class LongestSubstringWihUniqueCharacters {

    public static void main(String[] args) {
        String input = "aabbcc";
        int k = 2;
        System.out.println(findLongestString(input, k));
    }

    private static int findLongestString(String input, int k) {
        int leftIndex = 0;
        int maxLength = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        for (int rightIndex = 0; rightIndex < input.length(); rightIndex++) {
            addToMap(countMap, input.charAt(rightIndex));
            if (countMap.size() == k) {
                maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
            } else if (countMap.size() > k) {
                while (countMap.size() > k) {
                    removeFromMap(countMap, input.charAt(leftIndex));
                    leftIndex++;
                }
            }
        }
        return maxLength;
    }

    public static void addToMap(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }

    public static void removeFromMap(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            if (map.get(c) == 1) {
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        } else {
            throw new RuntimeException("Map doesn't contain the key '" + c + "'");
        }
    }
}
