package stream.k_range;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sample {

    public static void main(String[] args) {
        System.out.println("---------- Example 1 ----------");
        IntStream.rangeClosed(1, 5).forEach(System.out::println);

        System.out.println("---------- Example 2 ----------");
        IntStream.range(1, 5)
            .mapToObj(n -> "number : " + n)
            .collect(Collectors.toList())
            .forEach(System.out::println);
    }
}
