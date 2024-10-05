import java.util.*;
import java.io.*;

public class Main {

    static int[][] dp = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 41; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            bw.write(dp[N][0] + " " + dp[N][1] + "\n");
        }
        bw.flush();
    }

    static int[] fibonacci(int N) {
        if (dp[N][0] == -1 || dp[N][1] == -1) {
            dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
            dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
        }

        return dp[N];
    }
}