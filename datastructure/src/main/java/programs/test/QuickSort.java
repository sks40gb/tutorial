package programs.test;



public class QuickSort extends Sort {

    public static void main(String[] args) {             //pValue = 4, pIndex = 0
        int[] arr = {5, 3, 7, 1, 8, 4, 9};              // {5, 3, 7, 1, 8, 4}
        sort(arr,0, arr.length-1);
        print(arr);
    }

    private static void sort(int[] arr, int startIndex, int endIndex) {
        if(startIndex < endIndex){
            int pavot = arr[endIndex];
            int pIndex = startIndex;
            for (int i = startIndex; i <= endIndex; i++) {
                if(arr[i] < pavot){
                    swap(arr, i, pIndex);
                    pIndex++;
                }
            }
            swap(arr, pIndex, endIndex);
            sort(arr,startIndex,pIndex-1);
            sort(arr,pIndex+1, endIndex);
        }
    }

    private static void swap(int[] arr, int i, int pIndex) {
        int temp = arr[i];
        arr[i] = arr[pIndex];
        arr[pIndex] = temp;
    }

}
