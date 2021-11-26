package programs.test;

public class SelectionSort {

    public static void main(String[] args) {
       int[] arr = {5, 3, 7, 1, 8, 4, 9};
    }

    private static void sort(int[] arr) {
        for (int currentIndex = 0; currentIndex < arr.length; currentIndex++) {
            int minIndex = getMinIndex(arr, currentIndex); //0
            swap(arr, minIndex, currentIndex);
        }
    }

    private static int getMinIndex(int[] arr, int currentIndex) { //0
        int minIndex = currentIndex;                                //minIndex = 0, currentIndex =0
        for (int i = currentIndex + 1; i < arr.length; i++) {       // i = 1
            if(arr[i] < arr[minIndex]){                  // (3 < 5), false |
                minIndex =  i;
            }
        }
       return minIndex;
    }

    private static void swap(int[] arr, int currentIndex, int minIndex) {
        int tempValue = arr[currentIndex];
        arr[currentIndex] = arr[minIndex];
        arr[minIndex] = tempValue;
    }

    public static void print(int[] arr){
        System.out.println("---- print ----");
        for (int item : arr){
            System.out.println(item);
        }
    }


}
