package com.core.functional;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

/**
 * @author sunsingh
 */
public class F_Function {

    @Test
    public void exampleOne() {
        Function<Integer, Integer> sqr = n -> n * n;
        Integer result = sqr.apply(10);
        System.out.println("Sqrt of 10 is " + result);

    }

}
