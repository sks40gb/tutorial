package programs.recursive;

public class MergeSorting {

    public static void main(String[] args) {
        int[] arr = {12,11,13,5,6,7};
        int[] sortedArray = mergeSort(arr, 0, arr.length - 1);
        System.out.println("-------");
        for (int item : sortedArray) {
            System.out.println(item);
        }
        System.out.println("-------");
    }

    private static int[] mergeSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return new int[]{arr[startIndex]};
        } else {
            int midIndex = (startIndex + endIndex) / 2;
            int[] leftArray = mergeSort(arr, startIndex, midIndex);
            int[] rightArray = mergeSort(arr, midIndex + 1, endIndex);
            int[] result = new int[leftArray.length + rightArray.length];

            for (int i = 0, l = 0, r = 0; i < result.length; i++) {
                if(leftArray.length > l && rightArray.length > r){
                    if(leftArray[l] < rightArray[r]){
                        result[i] = leftArray[l];
                        l++;
                    }else{
                        result[i] = rightArray[r];
                        r++;
                    }
                }else if(leftArray.length > l){
                    result[i] = leftArray[l];
                    l++;
                }else if(rightArray.length > r){
                    result[i] = rightArray[r];
                    r++;
                }
            }
            return result;
        }
    }
}

