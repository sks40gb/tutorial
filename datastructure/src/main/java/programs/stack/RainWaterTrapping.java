package programs.stack;

import java.util.Stack;

/**
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

    public static int solution2(int[] arr) {
        // Stores the indices of the bars
        Stack<Integer> stack = new Stack<>();

        // size of the array
        int n = arr.length;

        // Stores the final result
        int ans = 0;

        // Loop through the each bar
        for (int i = 0; i < n; i++) {

            // Remove bars from the stack
            // until the condition holds
            while ((!stack.isEmpty())
                && (arr[stack.peek()] < arr[i])) {

                // store the height of the top
                // and pop it.
                int pop_height = arr[stack.peek()];
                stack.pop();

                // If the stack does not have any
                // bars or the the popped bar
                // has no left boundary
                if (stack.isEmpty())
                    break;

                // Get the distance between the
                // left and right boundary of
                // popped bar
                int distance = i - stack.peek() - 1;

                // Calculate the min. height
                int min_height
                    = Math.min(arr[stack.peek()],
                    arr[i])
                    - pop_height;

                ans += distance * min_height;
            }

            // If the stack is either empty or
            // height of the current bar is less than
            // or equal to the top bar of stack
            stack.push(i);
        }
        return ans;
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

}
