package algorithm;

public class Test {

    public static void main(String[] args) {
        int[] tops    = {2,1,2,4,2,2};
        int[] bottoms = {5,9,6,2,3,2};
        System.out.println(dominoes(tops, bottoms));
    }

    static int dominoes(int[] a, int[] b) {
        int first = a[0];
        int second = b[0];

        int swap1 = 0;
        for (int i = 1; i < a.length; i++) {
            if (first == a[i]) {
                continue;
            }
            if (first == b[i]) {
                swap1++;
                continue;
            }
            swap1 = -1;
        }

        int swap2 = 0;
        for (int i = 1; i < a.length; i++) {
            if (first == b[i]) {
                continue;
            }
            if (first == a[i]) {
                swap2++;
                continue;
            }
            swap2 = -1;
        }

        int swap3 = 0;
        for (int i = 1; i < a.length; i++) {
            if (second == b[i]) {
                continue;
            }
            if (second == a[i]) {
                swap3++;
                continue;
            }
            swap3 = -1;
        }


        int swap4 = 0;
        for (int i = 1; i < a.length; i++) {
            if (first == b[i]) {
                continue;
            }
            if (first == a[i]) {
                swap4++;
                continue;
            }
            swap4 = -1;
        }
        return min(swap1, swap2, swap3, swap4);


    }

    private static int match(int v, int[] a, int[] b){
        int swap = 0;
        for (int i = 1; i < a.length; i++) {
            if (v == b[i]) {
                continue;
            }
            if (v == a[i]) {
                swap++;
                continue;
            }
            swap = -1;
        }
        return swap;
    }

    private static int min(Integer ... numbers) {
        int min = -1;
        for (int n : numbers) {
            if(n != -1){
                if(min == -1){
                    min = n;
                }else{
                     min = Math.min(min, n);
                }
            }
        }
        return min;
    }

}
