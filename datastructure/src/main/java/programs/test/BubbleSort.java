package programs.test;

public class BubbleSort extends Sort{

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 1, 8, 4, 9};
        for (int i = 0; i < arr.length; i++) {
            bubble(arr, i);
        }
        print(arr);
    }

    private static void bubble(int[] arr, int i) {
        for (int currentIndex = 0; currentIndex < arr.length - i -1; currentIndex++) {
            int nextIndex = currentIndex + 1;
            swap(arr, currentIndex, nextIndex);
        }
    }

    private static void swap(int[] arr, int currentIndex, int nextIndex) {
        if(arr[currentIndex] > arr[nextIndex]){
            int tempValue = arr[currentIndex];
            arr[currentIndex] = arr[nextIndex];
            arr[nextIndex] = tempValue;
        }
    }
}
