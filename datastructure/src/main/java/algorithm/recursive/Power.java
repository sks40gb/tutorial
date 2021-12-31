package algorithm.recursive;

public class Power {

    public static void main(String[] args) {
        int power = power(2,5);
        System.out.println(power);
        System.out.println(Math.pow(2,5));
    }

    private static int power(int number, int times){
        if(times == 0){
            return 1;
        }
        return number * power(number, --times);
    }
}

