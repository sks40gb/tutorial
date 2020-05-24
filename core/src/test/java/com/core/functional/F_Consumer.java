package com.core.functional;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 * @author sunsingh
 */
public class F_Consumer {

    @Test
    public void exampleOne() {

        Consumer<Integer> c = n -> System.out.println("Printing Number : " + n);
        c.accept(100);

    }

}
