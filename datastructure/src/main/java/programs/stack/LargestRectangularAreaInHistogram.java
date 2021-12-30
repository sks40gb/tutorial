package programs.stack;

import java.util.Stack;

public class LargestRectangularAreaInHistogram {

    public static void main(String[] args) {
        int[] input =  {6, 2, 5, 4, 5, 1, 6};
        System.out.println(maxArea(input));
    }

    public static int maxArea(int[] input){
        int[] left = getLeftDistance(input);
        int[] right = getRightDistance(input);

        int maxArea = 0;
        for(int i=0; i < input.length; i++){
            int area = input[i] * (right[i] - left[i] - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private static int[] getLeftDistance(int[] input){

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[input.length];

        for(int i =0; i < input.length; i++){
            while(!stack.empty() && input[stack.peek()] > input[i]){
                stack.pop();
            }
            if(stack.empty()){
                result[i] = -1;
            }else{
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    private static int[] getRightDistance(int[] input){

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[input.length];

        for(int i = input.length - 1;i >=  0; i--){
            while(!stack.empty() && input[stack.peek()] > input[i]){
                stack.pop();
            }
            if(stack.empty()){
                result[i] =i+1;
            }else{
                result[i] = stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

}
