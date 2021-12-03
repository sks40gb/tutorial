package programs.recursive.medium;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

    public static void main(String[] args) {
        int[][] maze =
            {
                {1, 0, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 1}
            };
        RatInMaze ratInMaze = new RatInMaze();
        ratInMaze.walk(maze, 4, 4, 0, 0, null);
    }

    public void walk(int[][] maze, int m, int n, int i, int j, List<Point> path) {
        // System.out.println("[" + m + "," + n + "," + i + "," + j + "]");
//        System.out.println(isVisited(i, j, path));
        if (path == null) {
            path = new ArrayList<>();
        }

        if (isOutOfRange(m, n, i, j) || isVisited(i, j, path)) {
            return;
        }
        if (isDestination(m, n, i, j)) {
            path.add(new Point(i, j));
            printPath(path);
            return;
        }
        if (isSafe(maze, m, n, i + 1, j)) {
            path.add(new Point(i, j));
            walk(maze, m, n, i + 1, j, path);
            path.remove(path.size()- 1);
        }
        if (isSafe(maze, m, n, i - 1, j)) {
            path.add(new Point(i, j));
            walk(maze, m, n, i - 1, j, path);
            path.remove(path.size()- 1);
        }
        if (isSafe(maze, m, n, i, j + 1)) {
            path.add(new Point(i, j));
            walk(maze, m, n, i, j + 1, path);
            path.remove(path.size()- 1);
        }
        if (isSafe(maze, m, n, i, j - 1)) {
            path.add(new Point(i, j));
            walk(maze, m, n, i, j - 1, path);
            path.remove(path.size()- 1);
        }
    }

    private boolean isDestination(int m, int n, int i, int j) {
        return i == n - 1 && j == m - 1;
    }

    private boolean isOutOfRange(int m, int n, int i, int j) {
        return (i >= n || i < 0 || j >= m || j < 0);
    }

    private boolean isSafe(int[][] maze, int m, int n, int i, int j) {
        return (!isOutOfRange(m, n, i, j) && maze[i][j] == 1);
    }

    private boolean isVisited(int i, int j, List<Point> path) {
        for (Point point : path) {
            if (point.x == i && point.y == j) {
                return true;
            }
        }
        return false;
    }

    private static void printPath(List<Point> list) {
        System.out.println("---------------");
        for (Point p : list) {
            System.out.println("[" + p.x + "," + p.y +"]");
        }
    }

    class Point {
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }
}
