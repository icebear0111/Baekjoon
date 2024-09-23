import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int pointer = 0;
        String base = null;

        for (int i = 1; ; i++) {
            base = String.valueOf(i);
            for(int j = 0; j < base.length(); j++) {
                if (number.charAt(pointer) == base.charAt(j)) {
                    pointer++;
                }
                if (pointer == number.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}