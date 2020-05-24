package com.core.functional;

import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 *
 * @author sunsingh
 */
public class J_UnaryAndBinaryOperator {

    /**
     * UnaryOperator<T> extends Function<T, T>
     */
    @Test
    public void unaryOperatorExample() {
        UnaryOperator<Integer> sqr = (n) -> n * n;
        System.out.println("Sqr of 4 : " + sqr.apply(4));
    }

    /**
     * BinaryOperator<T> extends BiFunction<T,T,T>
     */
    @Test
    public void binaryOperatorExample() {
        BinaryOperator<String> empployee = (fname, lname) -> ("Hell Mr." + fname + " " + lname);
        String fullName = empployee.apply("Sunil", "Singh");
        System.out.println(fullName);
    }

}
