package programs.stack;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/trapping-rain-water/
 *
 * Example :
 *
 * Input : {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
 * Output : 6
 *
 * Input : {3, 0, 2, 0, 4}
 * Output : 7
 */
public class RainWaterTrapping {

    public static void main(String[] args) {
        int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution1(input));
        System.out.println(solution2(input));
        System.out.println(solution3(input));
    }

    private static int solution1(int[] input) {

        int[] leftMax = getLeftMax(input);
        int[] rightMax = getRightMax(input);

        int area = 0;
        for (int i = 1; i < input.length - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > input[i]) {
                area += min - input[i];
            }
        }
        return area;
    }

    private static int[] getLeftMax(int[] input) {

        int[] max = new int[input.length];
        //Exclude the current element
        for (int i = 1; i < input.length - 1; i++) {
            max[i] = Math.max(max[i - 1], input[i - 1]);
        }
        return max;
    }


    private static int[] getRightMax(int[] input) {
        int[] max = new int[input.length];
        //Exclude the current element
        for (int i = input.length - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], input[i + 1]);
        }
        return max;
    }

    /**
     * Solution using Stack
     */
    public static int solution2(int[] arr) {
        // Stores the indices of the bars
        Stack<Integer> stack = new Stack<>();

        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {

            while ((!stack.isEmpty()) && (arr[stack.peek()] < arr[i])) {

                int popHeight = arr[stack.pop()];

                if (stack.isEmpty()) {
                    break;
                }

                // Get the distance between the
                // left and right boundary of
                // popped bar
                int distance = i - stack.peek() - 1;

                // Calculate the min. height
                int min_height = Math.min(arr[stack.peek()], arr[i]) - popHeight;

                ans += distance * min_height;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * Using two pointer technique
     * https://youtu.be/m18Hntz4go8?t=534
     */
    public static int solution3(int[] arr) {

        int length = arr.length;
        int maxLeft = 0;
        int maxRight = 0;
        int totalWater = 0;
        int pL = 0;
        int pR = length - 1;

        while (pL < pR) {
            int leftPointerValue = arr[pL];
            int rightPointerValue = arr[pR];
            if (leftPointerValue <= rightPointerValue) {
                if (leftPointerValue >= maxLeft) {
                    maxLeft = leftPointerValue;
                } else {
                    totalWater += maxLeft - leftPointerValue;
                }
                pL++;
            } else {
                if (rightPointerValue >= maxRight) {
                    maxRight = rightPointerValue;
                } else {
                    totalWater += maxRight - rightPointerValue;
                }
                pR--;
            }
        }
        return totalWater;
    }

}
