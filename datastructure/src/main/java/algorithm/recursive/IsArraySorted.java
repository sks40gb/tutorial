package algorithm.recursive;

public class IsArraySorted {

    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{1, 2, 3, 4, 5}, 0));
        System.out.println(isSorted(new int[]{1, 2, 3, 5, 4}, 0));
    }

    private static boolean isSorted(int[] arr, int index) {
        if (index >= arr.length - 1) {
            return true;
        }

        if (arr[index] < arr[index + 1]) {
            return isSorted(arr, index + 1);
        } else {
            return false;
        }
    }
}
