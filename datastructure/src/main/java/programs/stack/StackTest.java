package programs.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        List<Integer> result = resolve(arr);
        System.out.println(result);

    }

    public static List<Integer> resolve(int[] input){

        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0; i < input.length; i++){
            while(!stack.empty() && input[stack.peek()] <  input[i]){
                stack.pop();
            }
            if(stack.empty()){
                list.add(1);
            }else{
                list.add(i-stack.peek());
            }
            stack.push(i);
        }
        return list;
    }



}
