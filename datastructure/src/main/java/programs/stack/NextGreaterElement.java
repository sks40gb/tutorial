package programs.stack;

// A Stack based Java program to find next
// greater element for all array elements
// in same order as input.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {11, 13, 21, 3};
        System.out.println(printNGE(arr));
    }

    public static List<Integer> printNGE(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                result.add(-1);
                stack.add(arr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    result.add(-1);
                } else {
                    result.add(stack.peek());
                }
                stack.push(arr[i]);
            }
        }
        Collections.reverse(result);
        return result;
    }

//    public static void printNGE(int arr[]) {
//        Stack<Integer> s = new Stack<>();
//        int nge[] = new int[arr.length];
//
//        for (int i = arr.length - 1; i >= 0; i--) {
//            if (!s.empty()) {
//                while (!s.empty()
//                    && s.peek() <= arr[i]) {
//                    s.pop();
//                }
//            }
//            nge[i] = s.empty() ? -1 : s.peek();
//            s.push(arr[i]);
//        }
//        for (int i = 0; i < arr.length; i++)
//            System.out.println(arr[i] +
//                " --> " + nge[i]);
//    }

}
