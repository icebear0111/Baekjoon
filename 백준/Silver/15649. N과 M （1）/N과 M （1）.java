import java.util.*;
import java.io.*;

public class Main {

    public static int N, M;
    public static int[] arr;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N];
        
        dfs(0);
        System.out.println(sb);
    }
    
    public static void dfs(int depth) {
        if (depth == M) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}