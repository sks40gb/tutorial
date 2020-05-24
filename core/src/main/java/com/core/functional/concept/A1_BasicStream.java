package com.core.functional.concept;

import java.util.Arrays;
import java.util.List;

public class A1_BasicStream {

    public static void main(String[] args) {

        Integer[] numbers = {1, 3, 9, 3, 4, 5, 6, 7, 0, 2};

        List<Integer> integerList = Arrays.asList(numbers);
        integerList.stream()
                .sorted()
                .filter(n -> n >= 5)
                .limit(2)
                .forEach(System.out::println);
    }
}