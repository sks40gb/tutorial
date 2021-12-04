package algorithm.twopointer;

public class Sort_an_array_of_zero_one_two {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};
        sort(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static void sort(int[] arr) {
        int left = 0;
        int index = 0;
        int right = arr.length - 1;
        while (index <= right) {
            int value = arr[index];
            if (value == 0) {
                swap(arr, left, index);
                left++;
                index++;
            } else if (value == 2) {
                swap(arr, right, index);
                right--;
            } else if (value == 1) {
                index++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int value = arr[i];
        arr[i] = arr[j];
        arr[j] = value;
    }

}
