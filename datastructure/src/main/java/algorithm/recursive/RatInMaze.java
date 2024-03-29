package algorithm.recursive;

import java.util.Vector;

/**
 * https://www.geeksforgeeks.org/rat-in-a-maze-problem-when-movement-in-all-possible-directions-is-allowed
 *
 * Output : DDRRURRDDD DDRURRRDDD DRDRURRDDD DRRRRDDD
 */
public class RatInMaze {
    static Vector<String> possiblePaths = new Vector<>();
    static final int MAX = 5;


    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1}};
        int n = m.length;
        printPath(m, n,"");
    }

    static boolean isSafe(int row, int col, int[][] m, int n, boolean[][] visited) {
        if (row == -1 || row == n || col == -1 ||
            col == n || visited[row][col] ||
            m[row][col] == 0)
            return false;

        return true;
    }

    static void printPath(int row, int col, int m[][], int n, boolean[][] visited, String path) {

        // This will check the initial point
        // (i.e. (0, 0)) to start the paths.
        if (row == -1 || row == n || col == -1 ||
            col == n || visited[row][col] ||
            m[row][col] == 0)
            return;

        // If reach the last cell (n-1, n-1)
        // then store the path and return
        if (row == n - 1 && col == n - 1) {
            possiblePaths.add(path);
            return;
        }

        // Mark the cell as visited
        visited[row][col] = true;

        // Try for all the 4 directions (down, left,
        // right, up) in the given order to get the
        // paths in lexicographical order

        // Check if downward move is valid
        if (isSafe(row + 1, col, m, n, visited)) {
            path += 'D';
            printPath(row + 1, col, m, n, visited, path);
            path = path.substring(0, path.length() - 1);
        }

        // Check if the left move is valid
        if (isSafe(row, col - 1, m, n, visited)) {
            path += 'L';
            printPath(row, col - 1, m, n, visited, path);
            path = path.substring(0, path.length() - 1);
        }

        // Check if the right move is valid
        if (isSafe(row, col + 1, m, n, visited)) {
            path += 'R';
            printPath(row, col + 1, m, n, visited, path);
            path = path.substring(0, path.length() - 1);
        }

        // Check if the upper move is valid
        if (isSafe(row - 1, col, m, n, visited)) {
            path += 'U';
            printPath(row - 1, col, m, n, visited, path);
            path = path.substring(0, path.length() - 1);
        }

        // Mark the cell as unvisited for
        // other possible paths
        visited[row][col] = false;
    }

    // Function to store and print
// all the valid paths
    static void printPath(int m[][], int n, String path) {
        boolean[][] visited = new boolean[n][MAX];

        // Call the utility function to
        // find the valid paths
        printPath(0, 0, m, n, visited, path);

        // Print all possible paths
        for (int i = 0; i < possiblePaths.size(); i++)
            System.out.print(possiblePaths.get(i) + " ");
    }

}

