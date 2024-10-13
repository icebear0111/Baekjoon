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
        }
        else {
            bfs(N);
        }
    }

    static void bfs(int N) {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        int time = 0;
        while (true) {
            time++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int current = q.poll();
                visited[current] = true;

                if (current - 1 == K || current + 1 == K || current * 2 == K) {
                    System.out.println(time);
                    return;
                }
                if (current - 1 >= 0 && !visited[current - 1]) {
                    visited[current - 1] = true;
                    q.add(current - 1);
                }
                if (current + 1 <= 100000 && !visited[current + 1]) {
                    visited[current + 1] = true;
                    q.add(current + 1);
                }
                if (current * 2 <= 100000 && !visited[current * 2]) {
                    visited[current * 2] = true;
                    q.add(current * 2);
                }
            }
        }
    }
}
