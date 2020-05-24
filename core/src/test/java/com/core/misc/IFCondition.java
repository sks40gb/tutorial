package com.core.misc;

import org.junit.jupiter.api.Test;

/**
 * @author sunil
 */
public class IFCondition {

    @Test
    public void main() {


        if (getOne() ^ getTwo()) {
            System.out.println("======================== SUCCESSFULL");
        }

        if (getOne() | getTwo()) {
            System.out.println("======================== short circuite");
        }

        if (getOne() || getTwo()) {
            System.out.println("======================== non short circuite");
        }
    }

    private static boolean getOne() {
        System.out.println("ONE");
        return true;
    }

    private static boolean getTwo() {
        System.out.println("TWO");
        return false;
    }
}
