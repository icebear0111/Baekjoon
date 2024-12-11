import java.util.*;

public class Main {
    static int T, n, result;
    static int[] arr;
    static boolean[] visited;
    static boolean[] inTeam;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            n = sc.nextInt();
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            inTeam = new boolean[n + 1];
            result = 0;

            for (int j = 1; j <= n; j++) {
                arr[j] = sc.nextInt();
            }

            for (int j = 1; j <= n; j++) {
                if (!inTeam[j]) {
                    dfs(j);
                }
            }
            System.out.println(n - result);
        }
    }

    static void dfs(int n) {
        if (visited[n]) {
            inTeam[n] = true;
            result++;
        }
        else {
            visited[n] = true;
        }

        if (!inTeam[arr[n]]) {
            dfs(arr[n]);
        }

        inTeam[n] = true;
        visited[n] = false;
    }
}