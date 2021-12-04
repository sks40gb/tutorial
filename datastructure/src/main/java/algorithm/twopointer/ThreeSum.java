package algorithm.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
//
//    Input:nums =[-1,0,1,2,-1,-4]
//    Output:[[-1,-1,2],[-1,0,1]]

    public static void main(String[] s) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  //{-4,-1,-1,0,1,2}
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            twoSum(nums, i + 1, target, result);

        }
        return result;
    }

    private void twoSum(int[] numbers, int index, int target, List<List<Integer>> result) {
        int left = index;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(-target);
                list.add(numbers[left]);
                list.add(numbers[right]);
                result.add(list);
                left++;
                while (numbers[left - 1] == numbers[left] && left < right) {
                    left++;
                }
            }
            if (sum < target) {
                left++;
            }
            if (sum > target) {
                right--;
            }
        }

    }


}
