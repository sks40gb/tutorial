
package com.core.misc;

import org.junit.jupiter.api.Test;

/**
 * @author Sunil
 */
public class StringTest {

    @Test
    public void compareString() {
        String s1 = "ABC";
        String s2 = "ABC";
        String s3 = new String("ABC");
        String s4 = new String("ABC");

        System.out.println(s1 == s2);
        System.out.println(s3 == s4);

    }

}
