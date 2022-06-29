package programs.stack;

import java.util.Stack;

public class LargestRectangularAreaInHistogram {

    public static void main(String[] args) {
        int[] input = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(new LargestRectangularAreaInHistogram().largestRectangleArea(input));
    }

    public int largestRectangleArea(int[] input) {

        int[] leftMinIndices = getLeftMinIndices(input);
        int[] rightMinIndices = getRightMinIndices(input);

        int max = 0;
        for (int i = 0; i < leftMinIndices.length; i++) {
            int left = leftMinIndices[i] == -1 ? 0 : leftMinIndices[i] + 1;
            int right = rightMinIndices[i] == -1 ? input.length - 1 : rightMinIndices[i] - 1;
            max = Math.max(max, (right - left + 1) * input[i]);
        }
        return max;
    }

    private int[] getLeftMinIndices(int[] input) {
        int[] result = new int[input.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            while (!stack.isEmpty() && input[stack.peek()] >= input[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    private int[] getRightMinIndices(int[] input) {
        int[] result = new int[input.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = input.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && input[stack.peek()] >= input[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }


}
