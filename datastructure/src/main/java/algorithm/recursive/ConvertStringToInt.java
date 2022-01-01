package algorithm.recursive;

/**
 * https://www.codingninjas.com/codestudio/problems/atoi_981270
 * 
 * 1. If the first char is ‘-’ it represents a minus sign and hence we return a
 * negative integer.
 * 2. If there is no number in the string, return 0.
 * 3. It is guaranteed that the number is less than or equal to 10^9.
 * 
 * Sample Input:
 * --------------------
 * 12439
 * -43534
 * app546er
 * cutedog
 * 
 * Sample Output :
 * ----------------------
 * 12439
 * -43534
 * 546
 * 0
 * 
 */
public class ConvertStringToInt {
    public static void main(String[] args) {
        String input = "-pp1-53er"; //-153
        int output= convertToInt(input);
        System.out.print(output);
    }

    private static int convertToInt(String input){
        int output =  parse(input, input.length() -1);
        if(input.charAt(0) == '-'){
            output = negate(output);
        }
        return output;
    }

    private static int parse(String s, int index) {
        if (index < 0) {
            return 0;
        }
        char c = s.charAt(index);
        Integer output = null;
        if (isIntValue(c)) {
            output =  parse(s, index - 1) * 10 + Character.getNumericValue(c);
        } else {
            output = parse(s, index - 1);
        }
        return output;
    }

    private static int negate(int number){
        return number * -1;
    }

    private static boolean isIntValue(char c) {
        return (c >= '0' && c <= '9');
    }
}

