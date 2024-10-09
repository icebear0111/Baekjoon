import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            if (num == 0) {
                num = 9;
            }
            sum += num;
        }

        System.out.println(sum);
    }
}