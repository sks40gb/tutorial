package algorithm.recursive;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/delete-middle-element-stack/
 * 
 * Given a stack with push(), pop(), empty() operations, delete middle of it
 * without using any additional data structure.
 * 
 * Input : Stack[] = [1, 2, 3, 4, 5]
 * Output : Stack[] = [1, 2, 4, 5]
 * 
 * Input : Stack[] = [1, 2, 3, 4, 5, 6]
 * Output : Stack[] = [1, 2, 4, 5, 6]
 * 
 */
public class RemoveMiddleElementFromStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        int middleIndex = stack.size()/2;
        System.out.println("------- Before ------");
        stack.stream().forEach(System.out::println);
        removeMiddleElement(stack, middleIndex);
        System.out.println("------- After ------");
        stack.stream().forEach(System.out::println);
    }

    private static void removeMiddleElement(Stack<Integer> stack, int k){
        int value = stack.pop();
        if(k == 0){
            return;
        }else{
            removeMiddleElement(stack, --k);
            stack.push(value);
        }
    }
}
