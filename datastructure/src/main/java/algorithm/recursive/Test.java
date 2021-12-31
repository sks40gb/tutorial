package algorithm.recursive;

public class Test {

    public static void main(String[] args) {
        System.out.println(findWays(3));
    }

    public static int findWays(int n) {
        if (n <= 2) {
            return n;
        }
        return findWays(n - 1) + findWays(n - 1) * (n - 2);
    }

}
