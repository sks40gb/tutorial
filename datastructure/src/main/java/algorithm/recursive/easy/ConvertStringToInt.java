package algorithm.recursive.easy;

/**
 * String to int
 * <p>
 * https://www.codingninjas.com/codestudio/problems/atoi_981270
 */
public class ConvertStringToInt {
    public static void main(String[] args) {
        String input = "-pp1-53er";
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
            output =  parse(s, index - 1) * 10 + getIntValue(c);
        } else {
            output = parse(s, index - 1);
        }
        return output;
    }

    private static int negate(int number){
        return number * -1;
    }
    private static int getIntValue(char c) {
        return Integer.parseInt(String.valueOf(c));
    }

    private static boolean isIntValue(char c) {
        return (c >= '0' && c <= '9');
    }
}
