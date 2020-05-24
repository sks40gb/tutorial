package com.core.functional;

import org.junit.jupiter.api.Test;

/**
 * All the static method must be defined within the interface and keep objected related information in classes.
 * In other
 * words, keep all static content in interface.
 * <p>
 * Static method defined in the interface can only be accessed through Interface name only.
 * <p>
 * interface can have main() method which can be called directly rather than creating the class for it.
 *
 * @author sunsingh
 */
public class D_StaticMethod {

    @Test
    public void main() {
        System.out.println(StringUtil.toUpperCase("John")); //@Valid
        //System.out.println(CommonUtil.toUpperCase("John")); // @Invalid
        //System.out.println(new CommonUtil().toUpperCase("John")); // @Invalid
    }

    interface StringUtil {

        public static String toUpperCase(String s) {
            return s.toUpperCase();
        }

        //this method can be called directly instead of creating new class for it.
        // Java StringUtil
        public static void main() {
            System.out.println("Main method inside interface");
        }
    }

    class CommonUtil implements StringUtil {

    }

}
