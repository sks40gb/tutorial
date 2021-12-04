package algorithm.recursive;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);

    }

    static void reverse(Stack<Integer> stack) {
        if (stack.size() > 0) {
            Integer x = stack.pop();
            reverse(stack);
            insert_at_bottom(stack, x);
        }
    }

    static void insert_at_bottom(Stack<Integer> stack, Integer x) {
        if (stack.isEmpty())
            stack.push(x);
        else {
            Integer a = stack.pop();
            insert_at_bottom(stack, x);
            stack.push(a);
        }
    }

}
