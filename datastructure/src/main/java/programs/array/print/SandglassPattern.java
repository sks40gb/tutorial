package programs.array.print;

import java.time.chrono.MinguoDate;

/**
 *              * * * * *
 *              * * * *
 *              * * *
 *              * *
 *              *
 *              *
 *              * *
 *              * * *
 *              * * * *
 *              * * * * *
 */
public class SandglassPattern {

    public static void main(String[] args) {
        print(9);
    }

    public static void print(int n) {
        int leftIndex = 0;
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            for (int spaceIndex = 0; spaceIndex < leftIndex; spaceIndex++) {
                System.out.print(" ");
            }
            for (int starIndex = leftIndex; starIndex < n - leftIndex; starIndex++) {
                System.out.print("*");
            }
            if (i < mid) {
                leftIndex++;
            } else {
                leftIndex--;
            }
            System.out.println();
        }
    }
}
