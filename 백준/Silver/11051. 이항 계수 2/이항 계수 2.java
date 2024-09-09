import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long P = 10007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long numer = fac(N);
        long denom = fac(K) * fac(N - K) % P;

        System.out.println(numer * pow(denom, P - 2) % P);
    }

    public static long fac(int n) {
        long result = 1;

        for (int i = 1; i <= n; i++) {
            result = (result * i) % P;
        }

        return result;
    }

    public static long pow(long base, long exp) {
        if (exp == 1) {
            return base % P;
        }

        long half = pow(base, exp / 2);

        if (exp % 2 == 0) {
            return half * half % P;
        }
        else {
            return half * half % P * base % P;
        }
    }
}
