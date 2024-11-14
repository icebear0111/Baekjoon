import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N);
        }
    }

    static void bfs(int N) {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = true;

        int[] time = new int[100001];
        time[N] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            // 순간이동의 경우
            if (current * 2 <= 100000 && !visited[current * 2]) {
                q.add(current * 2);
                visited[current * 2] = true;
                time[current * 2] = time[current];
            }

            // 걷기의 경우
            if (current - 1 >= 0 && !visited[current - 1]) {
                q.add(current - 1);
                visited[current - 1] = true;
                time[current - 1] = time[current] + 1;
            }
            if (current + 1 <= 100000 && !visited[current + 1]) {
                q.add(current + 1);
                visited[current + 1] = true;
                time[current + 1] = time[current] + 1;
            }

            // 위치에 도달한 경우
            if (visited[K]) {
                System.out.println(time[K]);
                return;
            }
        }
    }
}