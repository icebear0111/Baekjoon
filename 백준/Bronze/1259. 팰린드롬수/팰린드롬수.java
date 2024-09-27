import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            if (reverse(n) == n) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }

    static int reverse(int n) {
        int result = 0;

        while (n > 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }

        return result;
    }
}