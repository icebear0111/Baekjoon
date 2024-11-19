import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] dp = new int[N+2][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N+1; i++) {
            for (int j = 0; j < 10; j++) {
                int sum = 0;
                for (int k = j; k < 10; k++) {
                    sum += dp[i - 1][k];
                    sum %= 10007;
                }

                dp[i][j] = sum;
            }
        }

        System.out.println(dp[N+1][0]);
    }
}