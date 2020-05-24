package com.core.misc;

import org.junit.jupiter.api.Test;

/**
 * @author Sunil
 * <p>
 * %[arg_index$][flags][width][.precision] conversion char
 */
public class FormatEx {
    /**
     * For space
     */
    @Test
    public void format1() {
        System.out.println("FORMAT 1===============================");
        System.out.format(">%1$10d  %2$20d  <\n", 123, 2);
        System.out.format(">%1$10d  %2$20d  <\n", 12234323, 2);
        System.out.format(">%1$10d  %2$20d  <\n", 12234323, 223423);
        System.out.format(">%1$10d  %2$20d  <\n", 1234323423, 223432);
        System.out.format(">%1$10d  %2$20d  <\n", 123, 223423);
        System.out.format(">%1$10d  %2$20d  <\n", 1223234323, 223423);
    }

    /*
     * %    - fomrat starts with
     * 2$   - argument index
     * s    - type of argument
     * d    - type of argument
     * -    - left justify
     * 33   - size
     */
    @Test
    public void format2() {
        System.out.println("FORMAT 2===============================");
        System.out.format("%2$-33d     %1$s", "SINGH", 400);
        System.out.println("");
    }
}
