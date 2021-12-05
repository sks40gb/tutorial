package programs.array.print;

/**
 *              *
 *              * *
 *              * * *
 *              * * * *
 *              * * * * *
 *              * * * *
 *              * * *
 *              * *
 *              *
 */
public class RightStartPattern {

    public static void main(String[] args) {
        printRightStar(11);
    }

    private static void printRightStar(int n) {
        int mid = n / 2;
        int star = 0;
        for (int i = 0; i < n; i++) {
            if (i < mid) {
                star = i;
            } else {
                star = n - i - 1;
            }
            for (int j = 0; j <= star; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}












