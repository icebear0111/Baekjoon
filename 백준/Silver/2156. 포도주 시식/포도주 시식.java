import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] podoju = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            podoju[i] = sc.nextInt();
        }

        dp[1] = podoju[1];
        
        if (n > 1) {
            dp[2] = podoju[1] + podoju[2];
            
            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + podoju[i], dp[i - 3] + podoju[i - 1] + podoju[i]));
            }
        }

        System.out.println(dp[n]);
    }
}