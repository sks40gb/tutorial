package algorithm.slidingwindow.variable;

/**
 * Longest sub-array having sum k
 *
 * Note : This will work only with positive numbers
 *
 * Input : arr[] = { 10, 5, 2, 7, 1, 9 },  k = 15
 * Output : 4
 * The sub-array is {5, 2, 7, 1}.
 *
 * Input : arr[] = {-5, 8, -14, 2, 4, 12}, k = -5
 * Output : 5
 */
public class LongestSubarray {
    public static void main(String[] args) {
       testWithPositiveNumbersOnly();
       testWithNegativeNumbers();
    }

    private static void testWithPositiveNumbersOnly(){
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;
        int longest = findLongest(arr, k);
        System.out.println(longest);
    }

    private static void testWithNegativeNumbers(){
        int[] arr = {-5, 8, -14, 2, 4, 12};
        int k = -5;
        int longest = findLongest(arr, k);
        System.out.println(longest);
    }

    private static int findLongest(int[] arr, int k) {
        int sum = 0;
        int maxSize = 0;
        int leftIndex = 0;
        for (int rightIndex = 0; rightIndex < arr.length ; rightIndex++) {
            sum += arr[rightIndex];
            if(sum == k){
                maxSize = Math.max(maxSize, rightIndex - leftIndex + 1);
            }else if(sum > k){
                while(sum > k && leftIndex <= rightIndex){
                    sum -= arr[leftIndex];
                    leftIndex++;
                }
            }
        }
        return maxSize;
    }
}
