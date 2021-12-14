package programs.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PreviousSmallerElement {

    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};  //output : {-1, 4, 4, -1, 2}
        System.out.println(solve(arr));
    }

    private static List<Integer> solve(int[] arr) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            stack.push(arr[i]);
        }
        return result;
    }
}

