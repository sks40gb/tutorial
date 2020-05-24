package com.core.functional;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

/**
 * @author sunsingh
 */
public class G_Supplier {

    @Test
    public void exampleOne() {
        Supplier<Integer> s = () -> (int) (Math.random() * 10);
        System.out.println("RANDOM NUMBER : " + s.get());
    }

}
