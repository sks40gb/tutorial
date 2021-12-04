package algorithm.twopointer;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum2 {

    public static void main(String[] args) {
        int[] sortedNumbers = {2, 7, 11, 15};
        int target = 9;
        // Output: [1,2]
        for (int i : twoSum(sortedNumbers, target)) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }
            if (sum > target) {
                right--;
            }
            if (sum < target) {
                left++;
            }
        }
        return null;
    }

}
