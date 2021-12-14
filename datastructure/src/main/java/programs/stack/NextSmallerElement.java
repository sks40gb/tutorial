package programs.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


class NextSmallerElement {

    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        System.out.println(solve(arr));
    }

    private static List<Integer> solve(int[] arr) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
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
}

