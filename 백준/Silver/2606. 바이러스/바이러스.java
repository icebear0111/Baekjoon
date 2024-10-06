import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[][] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int x) {
        visited[x] = true;

        for (int i = 1; i <= n; i++) {
            if (graph[x][i] == 1 && !visited[i]) {
                count++;
                dfs(i);
            }
        }
    }
}