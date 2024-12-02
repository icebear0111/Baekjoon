import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxArea = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N][N];

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        for (int i = 0; i <= maxHeight; i++) {
            visited = new boolean[N][N];

            int area = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j][k] > i && !visited[j][k]) {
                        dfs(j, k, i);
                        area++;
                    }
                }
            }

            maxArea = Math.max(maxArea, area);
        }

        System.out.println(maxArea);
    }

    public static void dfs(int x, int y, int height) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

            if (arr[nx][ny] > height && !visited[nx][ny]) dfs(nx, ny, height);
        }
    }
}