package programs.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Input    :   { 1, 6, 4, 10 ,2 , 5 }
 * Output   :   {-1,-1, 6, -1 ,10, 10}
 */
public class PreviousGreaterElement {

    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 10, 2, 5};
        System.out.println(solve(arr));
    }

    public static List<Integer> solve(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] > stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                result.add(-1);
            }else{
                result.add(stack.peek());
            }
            stack.push(arr[i]);
        }
        return  result;
    }

}
