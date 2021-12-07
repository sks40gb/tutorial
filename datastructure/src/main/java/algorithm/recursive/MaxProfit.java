package algorithm.recursive;

public class MaxProfit {

    public static void main(String[] args) {
        int[] arr = {10, 22, 5, 75, 65, 80};
        maxProfit(arr, 4, true, 0, 0);
    }

    private static void maxProfit(int[] arr, int k, boolean buy, int index, int profit) {
       if(k == 0){
            System.out.println("Profit: " + profit);
            return;
        }
        if (index == arr.length) {
            System.out.println("Profit: " + profit);
            return;
        }
        if (buy) {
            maxProfit(arr, k - 1, false, index + 1, profit - arr[index]);
        }
        if (!buy) {
            //Sell
            maxProfit(arr, k - 1, true, index + 1, profit + arr[index]);
        }
        maxProfit(arr, k, buy, index + 1, profit);
    }
}
