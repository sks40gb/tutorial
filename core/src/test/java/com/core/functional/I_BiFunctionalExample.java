package com.core.functional;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

/**
 * @author sunsingh
 */
public class I_BiFunctionalExample {

    @Test
    public void BiFunctionExample() {
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println("Sum of 10 and 20 is : " + sum.apply(10, 20));
    }

    @Test
    public void BiPredicateExample() {
        BiPredicate<Integer, Integer> isMaxValue = (amount, max) -> amount >= max;
        System.out.println("Is 101 is max value of 100 : " + isMaxValue.test(101, 100));
    }

}
