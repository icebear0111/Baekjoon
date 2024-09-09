import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        int pisano = 1500000; // k(10^n) = 15 * 10^(n-1)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        n = n % pisano;
        long[] fibo = new long[(int)n + 1];

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000;
        }

        System.out.println(fibo[(int)n]);
    }
}
