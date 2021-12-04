package algorithm.recursive;

import java.util.Arrays;

public class QuickSorting {

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println("-------");
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("-------");
    }

    private static void sort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = arr[right];
        int pIndex = left;
        for (int i = left; i < right; i++) {
            if(arr[i] < pivot){
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex,right);
        sort(arr, left, pIndex-1 );
        sort(arr, pIndex+1, right);
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
