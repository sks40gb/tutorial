package algorithm.recursive;

public class MoveAllXtoEndOfString {

    public static void main(String[] args) {

        System.out.println(solution1("axbcxxd"));
    }

    public static String solution1(String input) {
        if (input.length() == 0) {
            return "";
        }
        String txt;
        if (input.charAt(0) == 'x') {
            txt = solution1(input.substring(1)) + 'x';
        } else {
            txt = input.charAt(0) + solution1(input.substring(1));
        }
        return txt;
    }

}
