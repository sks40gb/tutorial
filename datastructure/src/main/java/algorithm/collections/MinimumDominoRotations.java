package algorithm.collections;

/**
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 *
 * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom
 * halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 -
 * one on each half of the tile.)
 * 
 * We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
 * 
 * Return the minimum number of rotations so that all the values in tops are the
 * same, or all the values in bottoms are the same.
 * 
 * If it cannot be done, return -1.
 *
 * #google
 */
public class MinimumDominoRotations {
    public static void main(String[] args) {

        int[] tops = {2, 1, 2, 4, 2, 2};
        int[] bottoms = {5, 2, 6, 2, 3, 2};
        System.out.println(rotation(tops, bottoms));

    }

    private static int rotation(int[] tops, int[] bottoms) {

        int[] topsCount = new int[10];
        int[] bottomCount = new int[10];
        int[] sameCount = new int[10];

        for (int i = 0; i < tops.length; i++) {
            topsCount[tops[i]]++;
            bottomCount[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                sameCount[tops[i]]++;
            }
        }

        for (int i = 0; i < topsCount.length; i++) {
            if (topsCount[i] + bottomCount[i] - sameCount[i] == tops.length) {
                return Math.min(topsCount[i], bottomCount[i]) - sameCount[i];
            }
        }
        return -1;

    }

}
