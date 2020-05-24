package com.core.java8;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * optional.isPresent()
 *
 * optional.orElse()
 *
 * optional.orElseGet()
 *
 */
public class OptionalApp {

    @Test
    public void main()  {
        //Here is an Optional with null value
        Optional<String> optional = Optional.ofNullable(null);

        //Here is an Optional with non-null value
        Optional<String> sc = Optional.of("hello");

//        if(optional.isPresent()){
//            System.out.println("Optional " + optional.get());
//        }
        String s = optional.orElseGet(() -> {
            return "sunil " + "singh";
        });
        System.out.println(s);

    }
}
