/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.regex;

import org.junit.jupiter.api.Test;

/**
 * @author sunil
 */
public class StringTokenizer {

    @Test
    public void main() {
        String str = "sunil|kumar|singh";
        String deli = "\\|";

        String tokens[] = str.split(deli);

        for (String token : tokens) {
            System.out.println("==========> " + token);
        }

    }

}
