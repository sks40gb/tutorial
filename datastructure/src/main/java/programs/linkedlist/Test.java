package programs.linkedlist;

public class Test {

    public static void main(String[] args) {
        String input = "ABCDEF";
       findWays(input,"");
//        System.out.println(removeChar("sunil", 4));
        System.out.println(f(6));
    }

    public static void findWays(String input, String output) {
        if (input.length() == 0) {
            System.out.println("input : " + output);
            return;
        }
        char c = input.charAt(0);
        output += c;
        String str = removeChar(input, 0);
        findWays(str, output);
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            String newInput = removeChar(str, i);
            findWays(newInput,output+c);
        }
    }

    private static String removeChar(String input, int index) {
        return input.substring(0, index) + input.substring(index + 1);
    }

    public static int f(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return f(n - 1) + (n - 1) * f(n - 2);
    }
}
