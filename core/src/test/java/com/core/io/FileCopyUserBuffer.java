package com.core.io;

import org.junit.jupiter.api.Test;

import java.io.*;

public class FileCopyUserBuffer {  // Pre-JDK 7

    @Test
    public void main() throws IOException {
        String inFileStr = "test-in.jpg";
        String outFileStr = "test-out.jpg";
        long startTime, elapsedTime;  // for speed benchmarking

        // Check file length
        File fileIn = new File(inFileStr);
        System.out.println("File size is " + fileIn.length() + " bytes");

        try(FileInputStream in = new FileInputStream(inFileStr);
            FileOutputStream out = new FileOutputStream(outFileStr)) {
            startTime = System.nanoTime();
            byte[] byteBuf = new byte[4096];    // 4K byte-buffer
            int numBytesRead;
            while ((numBytesRead = in.read(byteBuf)) != -1) {
                out.write(byteBuf, 0, numBytesRead);
            }
            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");
        }
    }
}
