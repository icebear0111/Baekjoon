import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = 0;
        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            char ch = str.charAt(0);

            if (ch != 'F' && ch != 'B') {
                num = Integer.parseInt(str);
                num += 3 - i;
            }
        }

        if (num % 3 == 0) {
            if (num % 5 == 0) {
                bw.write("FizzBuzz");
            }
            else {
                bw.write("Fizz");
            }
        }
        else {
            if (num % 5 == 0) {
                bw.write("Buzz");
            }
            else {
                bw.write(String.valueOf(num));
            }
        }
        bw.flush();
    }
}