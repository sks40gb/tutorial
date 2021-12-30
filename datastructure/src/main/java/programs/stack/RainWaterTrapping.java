package programs.stack;

/**
 * Example :
 *
 * Input : {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
 * Output : 6
 *
 * Input : {3, 0, 2, 0, 4}
 * Output : 7
 */
public class RainWaterTrapping {

    public static void main(String[] args) {
        int[] input =  {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(maxArea(input));
    }

    private static int maxArea(int[] input){

        int[] leftMax = getLeftMax(input);
        int[] rightMax = getRightMax(input);

        int area = 0;
        for(int i=1; i < input.length-1; i++){
            int min = Math.min(leftMax[i], rightMax[i]);
            if(min > input[i]){
                area += min - input[i];
            }
        }
        return area;
    }

    private static int[] getLeftMax(int[] input){

        int[] max = new int[input.length];
        //Exclude the current element
        for(int i = 1; i < input.length -1; i++){
            max[i] = Math.max(max[i-1], input[i-1]);
        }
        return max;
    }


    private static int[] getRightMax(int[] input){
        int[] max = new int[input.length];
        //Exclude the current element
        for(int i = input.length -2; i >= 0; i--){
            max[i] = Math.max(max[i+1], input[i+1]);
        }
        return max;
    }

}
