package algorithm.recursive;

public class ReverseString {

    public static void main(String[] args) {
        String input = "sunil";
        System.out.println(reverse(input));
        System.out.println(reverse2(input));
    }

    public static String reverse(String input){
       if(input.length() == 1 ){
           return input;
       }
       String n_1 = input.substring(0, input.length() - 1);
       return input.charAt(input.length() - 1) + reverse(n_1);
    }

    public static String reverse2(String input){
        if(input.length() == 1){
            return input;
        }
        String n_1 = input.substring(1);
        return reverse2(n_1) + input.charAt(0);
    }
}
