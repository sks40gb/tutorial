package com.core.misc;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 *
 * @author ssi150
 */
public class MiscTest {

    public void readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()){
            System.out.println("THis is what you type : " + scanner.next());
        }

    }
}
