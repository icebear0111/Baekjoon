import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) { // 0번째 계단은 없다.
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1]; // 1번째 계단

        if (N >= 2) { // 2번째 계단
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= N; i++) {
            // 두 칸 전에서 올라온 경우 vs 한 칸 전에서 올라온 경우
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
        }

        System.out.println(dp[N]);
    }
}