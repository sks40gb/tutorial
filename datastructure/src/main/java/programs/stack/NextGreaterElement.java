package programs.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/next-greater-element/
 */
class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {11, 13, 21, 3};
        System.out.println(printNGE(arr));
    }

    public static List<Integer> printNGE(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            stack.add(arr[i]);
        }
        Collections.reverse(result);
        return result;
    }

    private static int[] previousGreaterElement_v2(int[] input) {
        int[] result = new int[input.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = input.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && input[i] > stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(input[i]);
        }
        return result;
    }


}
