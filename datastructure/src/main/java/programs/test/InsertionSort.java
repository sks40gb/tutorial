package programs.test;

public class InsertionSort extends Sort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 1, 8, 4, 9}; // {3, 5, 7, 1, 8, 4, 9}
        sort(arr);
        print(arr);
    }

    private static void sort(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            int value = arr[index];
            int hole = index;
            while(hole > 0 && arr[hole-1] > value){
                arr[hole] = arr[hole-1];
                hole--;
            }
            arr[hole] = value;
        }

    }


}
