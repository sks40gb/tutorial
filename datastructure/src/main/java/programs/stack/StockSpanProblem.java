package programs.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ]
 * Input   :  {100, 80, 60, 70, 60, 75, 85}
 * Output  :  {1, 1, 1, 2, 1, 4, 6}
 */
public class StockSpanProblem {
    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        List<Integer> result = resolve(arr);
        System.out.println(result);
    }

    private static List<Integer> resolve(int[] arr) {
        List<Integer> indices = new ArrayList<>();
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!indexStack.isEmpty() && arr[indexStack.peek()] < arr[i]) {
                indexStack.pop();
            }
            if (indexStack.isEmpty()) {
                indices.add(i+1);
            } else {
                indices.add(i-indexStack.peek());
            }
            indexStack.add(i);
        }
        return indices;
    }
}









