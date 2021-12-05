package programs.array.print;

/**
 * Print
 *
 *      ⦿
 *      ⦿⦿
 *      ⦿⦿⦿
 *      ⦿⦿⦿⦿
 *      ⦿⦿⦿⦿⦿
 *
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 */
public class TriangleUsingOneLoop {

    public static void main(String[] args) {
        char[][] matrix = new char[5][5];
        printTriangle(5);
    }


    private static void printTriangle(int n) {
        int line = 0;
        int star = 0;

        while(line < n){
            if(star < line){
                System.out.print("⦿");
                star++;
                continue;
            }
            star = 0;
            line++;
            System.out.println();
        }
    }


}
