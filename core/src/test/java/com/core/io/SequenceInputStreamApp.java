package com.core.io;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;

/**
 *
 * @author Sunil
 */
public class SequenceInputStreamApp {

    @Test
    public void main() throws  Exception{
        FileInputStream fileInputStream1 = new FileInputStream("Sayings.txt");  // first source file
        FileInputStream fileInputStream2 = new FileInputStream("Morals.txt");  //second source file

        SequenceInputStream sequenceInputStream = new SequenceInputStream(fileInputStream1, fileInputStream2);
        FileOutputStream fileOutputStream = new FileOutputStream("Result.txt");        // destination file

        int temp;
        while ((temp = sequenceInputStream.read()) != -1) {
            System.out.print((char) temp); // to print at DOS prompt
            fileOutputStream.write(temp);	// to write to file
        }
        fileOutputStream.close();
        sequenceInputStream.close();
        fileInputStream1.close();
        fileInputStream2.close();
    }
}
