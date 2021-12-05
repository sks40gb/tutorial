package algorithm.slidingwindow.fixed;

import java.util.*;

/**
 * Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.
 * <p>
 * Examples :
 * <p>
 * Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
 * Output: 3 3 4 5 5 5 6
 * <p>
 * Explanation:
 * Maximum of 1, 2, 3 is 3
 * Maximum of 2, 3, 1 is 3
 * Maximum of 3, 1, 4 is 4
 * Maximum of 1, 4, 5 is 5
 * Maximum of 4, 5, 2 is 5
 * Maximum of 5, 2, 3 is 5
 * Maximum of 2, 3, 6 is 6
 *
 * <p>
 * Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
 * Output: 10 10 10 15 15 90 90
 * Explanation:
 * Maximum of first 4 elements is 10, similarly for next 4
 * elements (i.e from index 1 to 4) is 10, So the sequence
 * generated is 10 10 10 15 15 90 90
 */
public class MaximumOfAllSubArray {

    public static void main(String[] args) {
        int[] arr = {-7, -8, 7, 5, 7, 1, 6, 0};
        int k = 4;
        for (int i : findKMaxElement(arr, k)) {
            System.out.print(i + " ");
        }
    }

    static ArrayList<Integer> findKMaxElement(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> maxList = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }
        maxList.add(queue.peek());

        for (int i = k; i < arr.length; i++) {
            queue.remove(arr[i-k]);
            queue.add(arr[i]);
            maxList.add(queue.peek());
        }
        return maxList;
    }

}
