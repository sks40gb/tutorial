package programs.recursive.easy;

public class Factorial {

    public static void main(String[] args) {
        int factorial = factorial(4); // 1x2x3x4 = 24
        System.out.println(factorial);
    }

    static int factorial(int n){
        if(n== 1){
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }
}
