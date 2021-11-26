package programs.test;


public class MergeSort extends Sort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 1, 8, 4, 9};              // {3, 5, 7, 1, 8, 4, 9}
        sort(arr, 0, arr.length-1);
        print(arr);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, start, mid);    // 1,1
            sort(arr, mid + 1, end);  // 2,3 -->
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        System.out.println(start + "--" + end + "--" + mid);
        int[] result = new int[end - start + 1];
        int index = 0;
        int firstIndex = start;
        int secondIndex = mid + 1;

        while (firstIndex <= mid && secondIndex <= end) {
            if (arr[firstIndex] < arr[secondIndex]) {
                result[index] = arr[firstIndex];
                firstIndex++;
            } else {
                result[index] = arr[secondIndex];
                secondIndex++;
            }
            index++;
        }

        while (firstIndex <= mid) {
            result[index] = arr[firstIndex];
            index++;
            firstIndex++;
        }

        while (secondIndex <= end) {
            result[index] = arr[secondIndex];
            index++;
            secondIndex++;
        }
        for (int i = 0; i < result.length; i++) {
            arr[start+i] = result[i];
        }
    }


}
