package algorithm.recursive;

import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        int[] input = {3, 1, 5, 6, 4, 2};
        List<String> result = longestValid(input);
        for (String line : result) {
//            System.out.println(line);
        }
    }

    private static List<String> longestValid(int[] input) {

        List<String> result = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            int min = Integer.MIN_VALUE;
            int max = findValidForElement(input, 0, i, min, result, "");
            System.out.println(max);
        }
        return result;
    }

    private static int findValidForElement(int[] input, int startIndex, int endIndex, int previousValue, List<String> result, String path) {

        int v = input[endIndex];
        if (startIndex >= endIndex) {
            path += "," + v;
            result.add(path);
            return 1;
        }

        int max = 0;
        for (int i = startIndex; i < endIndex; i++) {
            int currentValue = input[i];
            if (currentValue < v && currentValue > previousValue) {
                int m = findValidForElement(input, i + 1, endIndex, currentValue, result, path + "," + currentValue) + 1;
                max = Math.max(m, max);
            }else{
                int m = findValidForElement(input, i + 1, endIndex, previousValue, result, path);
                max = Math.max(m, max);
            }
        }
        return max;
    }


}
