package programs.recursive;

import java.util.Stack;

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
