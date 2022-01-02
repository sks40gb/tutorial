package algorithm.recursive;

/**
 * https://www.geeksforgeeks.org/tiling-problem/
 *
 * Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to
 * tile the given board using the 2 x 1 tiles. A tile can either be placed
 * horizontally i.e., as a 1 x 2 tile or vertically i.e., as 2 x 1 tile.
 *
 * Input: n = 4
 *
 * Output: 5
 *
 * Explanation:
 *
 * For a 2 x 4 board, there are 3 ways
 *
 * All 4 vertical (1 way)
 * All 4 horizontal (1 way)
 * 2 vertical and 2 horizontal (3 ways)
 */

public class TilingProblem {

    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int ways = numOfWays(n, m);
        System.out.println(ways);
    }

    private static int numOfWays(int n, int m) {

        if (n < m) {
            return 1;
        }
        if (n == m) {
            return 2;
        }
        int hPlacement = numOfWays(n - m, m);
        int vPlacement = numOfWays(n - 1, m);
        return hPlacement + vPlacement;
    }


}


