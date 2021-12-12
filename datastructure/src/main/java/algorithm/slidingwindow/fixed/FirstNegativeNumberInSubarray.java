package algorithm.slidingwindow.fixed;

import java.util.ArrayList;
import java.util.List;

/**
 * First Negative Number in every Window of Size K
 *
 * Input : arr[] = {12, -1, -7, 8, -15, 30, 16, 28} , k = 3
 * Output : -1 -1 -7 -15 -15
 *
 */
public class FirstNegativeNumberInSubarray {

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        System.out.println(findFirstNegativeNumber(arr,k));
    }

    public static List<Integer> findFirstNegativeNumber(int[] arr, int k){

        List<Integer> negativeNumbers = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0; i< k; i++){
            if(arr[i] < 0){
                negativeNumbers.add(arr[i]);
            }
        }

        if(!negativeNumbers.isEmpty()){
            result.add(negativeNumbers.get(0));
        }

        for(int i=k; i<arr.length; i++){
            if(arr[i-k] < 0){
                negativeNumbers.remove(0);
            }
            if(arr[i] < 0){
                negativeNumbers.add(arr[i]);
            }
            if(!negativeNumbers.isEmpty()){
                result.add(negativeNumbers.get(0));
            }
        }
        return result;
    }
}
