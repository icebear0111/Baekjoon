import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char ch;
        String output = "";
        
        for (int i = 0; i < a.length(); i++) {
            ch = a.charAt(i);
            
            if (Character.isUpperCase(ch))
                output += Character.toLowerCase(ch);
            if (Character.isLowerCase(ch))
                output += Character.toUpperCase(ch);
        }
        
        System.out.println(output);
    }
}