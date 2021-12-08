package algorithm.recursive;

public class StringPermutation {

    public static void main(String[] args) {
        new StringPermutation().stringPrint("ABC");
    }

    public void stringPrint(String s) {
        char[] input = s.toCharArray();
        print(input, 0);
    }


    public void print(char[] arr, int index) {
        if (index == arr.length - 1) {
            printArray(arr);
        } else {
            for (int i = index; i <= arr.length -1; i++) {
                swap(arr, index, i);
                print(arr, index + 1);
                swap(arr, i, index);
            }
        }
    }

    private void swap(char[] arr, int first, int second) {
        char c = arr[first];
        arr[first] = arr[second];
        arr[second] = c;
    }

    private void printArray(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println("");
    }

}
