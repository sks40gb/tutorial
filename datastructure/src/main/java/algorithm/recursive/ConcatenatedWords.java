package algorithm.recursive;

import java.util.*;

/**
 * https://leetcode.com/problems/concatenated-words/
 * Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
 *
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 *
 * Example 2:
 *
 * Input: words = ["cat","dog","catdog"]
 * Output: ["catdog"]
 *
 */
public class ConcatenatedWords {

    public static void main(String[] args) {
        String[] words = {"cat","dog","catdog"};
        System.out.println(findAllConcatenatedWordsInADict(words));
    }
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<String>();
        Set<String> set = new HashSet(Arrays.asList(words));

        for(String word : words) {
            set.remove(word);
            if(dfs(word, set, "")) list.add(word);
            set.add(word);
        }
        return list;
    }

    private static boolean dfs(String word, Set<String> set, String previous) {
        if(!previous.equals("")) set.add(previous);
        if(set.contains(word)) return true;

        for(int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0,i);
            if(set.contains(prefix) &&
                    dfs(word.substring(i,word.length()), set, previous+prefix)) {
                return true;
            }
        }
        return false;
    }
}
