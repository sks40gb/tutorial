package programs.slidingwindow;

/**
 * Find maximum (or minimum) sum of a subarray of size k
 */
public class MaximumSumOfSubarray {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        System.out.println(maxSum(arr, k));
    }

    public static int maxSum(int[] arr, int k){
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }
        int sum = maxSum;
        for(int i=k; i < arr.length; i++){
            sum = sum + arr[i] - arr[i-k];
            maxSum = Math.max(sum, maxSum);
        }
       return maxSum;
    }
}
