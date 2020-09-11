package string;

public class StringReverse {


    public static void main(String[] args) {
        String str = "abcd efg";
        System.out.println(reverse(str));
    }

    public static String reverse(String str) {
        String reverse="";
        for (int i=0; i<str.length();i++) {
            reverse = str.charAt(i) +reverse;
        }
        return reverse;
    }

    public static String reverse2(String str) {
        char[] chars = str.toCharArray();
        String reverse="";
        for(int i = chars.length-1; i>=0;i--) {
            reverse = reverse +chars[i];
        }
        return reverse;
    }

}


