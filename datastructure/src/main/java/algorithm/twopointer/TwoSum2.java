package algorithm.twopointer;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] > target) {
                    break;
                }
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

}
