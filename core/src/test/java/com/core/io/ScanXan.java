package com.core.io;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScanXan {

    @Test
    public void main() throws IOException {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("D:" + File.separator + "transaction.txt")));

            while (s.hasNextDouble()) {
                System.out.println(s.nextDouble());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
