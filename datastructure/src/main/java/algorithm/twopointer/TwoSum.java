package algorithm.twopointer;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        for (int i : findSum(nums, target)) {
            System.out.println(i);
        }
    }

    private static int[] findSum(int[] nums, int target) {
        Map<Integer, Integer> preMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (preMap.containsKey(nums[i])) {
                return new int[]{preMap.get(nums[i]), i};
            }
            preMap.put(target - nums[i], i);
        }
        return null;
    }
}
