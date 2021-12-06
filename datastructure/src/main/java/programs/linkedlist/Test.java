package programs.linkedlist;

public class Test {

    public static void main(String[] args) {
        String input = "ABCDEF";
        System.out.println(findWays(input,""));
//        System.out.println(removeChar("sunil", 4));
        System.out.println(f(6));
    }

    public static int  findWays(String input, String output) {
        if (input.length() == 0) {
            System.out.println("input : " + output);
            return 1;
        }
        char c = input.charAt(0);
        output += c;
        String str = removeChar(input, 0);
        int count = 0;
        count = count + findWays(str, output);
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            String newInput = removeChar(str, i);
            count = count + findWays(newInput,output+c);
        }
        return 0;
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
