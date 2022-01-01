package algorithm.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/stock-buy-sell/
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] arr = {12, 14, 17, 10, 14, 13, 12, 15};
        Map<Key, Integer> memo = new HashMap<>();
        int transaction = 3;
        System.out.println("Max profit : " + maxProfit(arr, transaction * 2, true, 0, 0, memo));
    }

    private static int maxProfit(int[] arr, int k, boolean buy, int index, int profit, Map<Key, Integer> memo) {

        if (index == arr.length || k == 0) {
            System.out.println("Profit: " + profit);
            return profit;
        }
        Key key = new Key(buy, index, profit);
        if (memo.containsKey(key)) {
            System.out.println("From memo.............");
            return memo.get(key);
        }
        int maxProfit = 0;
        if (buy) {
            maxProfit = Math.max(maxProfit, maxProfit(arr, k - 1, false, index + 1, profit - arr[index], memo));
        }
        if (!buy) {
            maxProfit = Math.max(maxProfit, maxProfit(arr, k - 1, true, index + 1, profit + arr[index], memo));
        }
        maxProfit = Math.max(maxProfit, maxProfit(arr, k, buy, index + 1, profit, memo));
        memo.put(key, maxProfit);
        return maxProfit;
    }

    static class Key {
        public boolean buy;
        public int index;
        public int profit;

        public Key(boolean buy, int index, int profit) {
            this.buy = buy;
            this.index = index;
            this.profit = profit;
        }

        public boolean equals(Object o) {
            Key key = (Key) o;
            return key.buy == buy && key.index == index && key.profit == profit;
        }

        public int hashCode() {
            return index;
        }
    }
}
