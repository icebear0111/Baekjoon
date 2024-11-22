import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        long[][] dp = new long[N][N]; // 경로의 개수는 2^63 - 1 보다 작거나 같다

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int jump = arr[i][j];

                if (jump == 0) break;

                if (j + jump < N) dp[i][j + jump] += dp[i][j];
                if (i + jump < N) dp[i + jump][j] += dp[i][j];
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}