package algorithm.slidingwindow.fixed;

/**
 * Find maximum (or minimum) sum of a subarray of size k
 *
 * Input  : arr[] = {100, 200, 300, 400}
 *          k = 2
 * Output : 700
 *
 * Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
 *          k = 4
 * Output : 39
 * We get maximum sum by adding subarray {4, 2, 10, 23}
 * of size 4.
 *
 * Input  : arr[] = {2, 3}
 *          k = 3
 * Output : Invalid
 * There is no subarray of size 3 as size of whole
 * array is 2.
 *
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
