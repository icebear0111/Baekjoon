import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int W = sc.nextInt();
        int[] jadu = new int[T + 1];
        int[][] dp = new int[W + 1][T + 1];

        for (int t = 1; t <= T; t++) {
            jadu[t] = sc.nextInt();
        }

        for (int w = 0; w <= W; w++) {
            int currentTree = (w % 2 == 0) ? 1 : 2;
            for (int t = 1; t <= T; t++) {
                dp[w][t] = dp[w][t - 1];
                if (w > 0) {
                    dp[w][t] = Math.max(dp[w][t], dp[w - 1][t - 1]);
                }

                if (jadu[t] == currentTree) {
                    dp[w][t]++;
                }
            }
        }

        int max = 0;
        for (int w = 0; w <= W; w++) {
            max = Math.max(max, dp[w][T]);
        }

        System.out.println(max);
    }
}