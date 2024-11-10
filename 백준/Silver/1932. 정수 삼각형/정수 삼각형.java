import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0]; // 맨 왼쪽 경로
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i]; // 맨 오른쪽 경로
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                // 중앙 경로. 왼쪽 대각선 위에서 오는 경우와 오른쪽 대각선 위에서 오는 경우 중 큰 값을 선택
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]); // 마지막 행에서 가장 큰 값
        }
        bw.write(max + "\n");
        bw.flush();
    }
}