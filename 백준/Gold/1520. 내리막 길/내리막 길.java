import java.util.*;
import java.io.*;

public class Main {
    static int M, N;
    static int[][] arr;
    static int[][] dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        arr = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1)
            return 1;

        if (dp[x][y] != -1)
            return dp[x][y];
        else {
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                if (arr[x][y] > arr[nx][ny])
                    dp[x][y] += dfs(nx, ny);
            }
        }

        return dp[x][y];
    }
}