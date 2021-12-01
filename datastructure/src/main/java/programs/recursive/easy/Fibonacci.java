package programs.recursive.easy;

public class Fibonacci {

    public static void main(String[] args) {
        fabonacci(5, 0, 1);
    }

    private static void fabonacci(int times, int n1, int n2){
        if(times == 0){
            return;
        }
        int newNumber = n1 + n2;
        System.out.println(newNumber);
        fabonacci(--times, n2, newNumber);
    }
}
