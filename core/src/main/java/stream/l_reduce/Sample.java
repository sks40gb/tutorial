package stream.l_reduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Sample {

    public static void main(String[] args) {
        concate();
        factorial();
    }


    public static void concate(){
        List<String> items = Arrays.asList("A", "B", "C", "D");
        String output = items.stream().reduce("",(result, item) -> result +"|" + item);
        System.out.println(output);
    }

    public static void factorial() {
        int factorialOf = 5;
        int result = IntStream.rangeClosed(1, factorialOf).reduce(1, (product, n) -> product * n);
        System.out.format("Factorial of %s is %s", factorialOf, result);
    }

}
