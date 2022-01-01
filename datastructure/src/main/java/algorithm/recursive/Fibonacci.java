package algorithm.recursive;

public class Fibonacci {

    public static void main(String[] args) {
        fabonacci(5, 0, 1);
    }

    private static void fabonacci(int times, int n1, int n2) {
        if (times == 0) {
            return;
        }
        int newNumber = n1 + n2;
        System.out.println(newNumber);
        fabonacci(--times, n2, newNumber);
    }

    // Function to print N Fibonacci Number
    static void fibonacci2(int N) {
        int num1 = 0, num2 = 1;

        int counter = 0;

        // Iterate till counter is N
        while (counter < N) {

            // Print the number
            System.out.print(num1 + " ");

            // Swap
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            counter = counter + 1;
        }
    }

    // Function to print the fibonacci series
    static int fib(int n) {
        // Base Case
        if (n <= 1)
            return n;

        // Recursive call
        return fib(n - 1)
                + fib(n - 2);
    }

    // Driver Code
    public static void main2(String args[]) {
        // Given Number N
        int N = 10;

        // Print the first N numbers
        for (int i = 0; i < N; i++) {

            System.out.print(fib(i) + " ");
        }
    }
}


// Dynamic Programming approach for
// Fibonacci Series

class FibonacciDP {

    // Function to find the fibonacci Series
    static int fib(int n) {

        // Declare an array to store
        // Fibonacci numbers.
        // 1 extra to handle case, n = 0
        int f[] = new int[n + 2];

        int i;

        // 0th and 1st number of
        // the series are 0 and 1
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {

            // Add the previous 2 numbers
            // in the series and store it
            f[i] = f[i - 1] + f[i - 2];
        }

        // Nth Fibonacci Number
        return f[n];
    }

    public static void main(String args[]) {
        // Given Number N
        int N = 10;

        // Print first 10 term
        for (int i = 0; i < N; i++)
            System.out.print(fib(i) + " ");
    }
}