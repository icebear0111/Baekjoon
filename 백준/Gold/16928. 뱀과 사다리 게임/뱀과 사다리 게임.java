import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] ladder;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ladder = new int[101];
        visited = new int[101];

        for (int i = 1; i < ladder.length; i++) {
            ladder[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ladder[x] = y;
        }

        int answer = bfs();
        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = current + i;

                if (next > 100) {
                    continue;
                }

                int destination = ladder[next];

                if (visited[destination] == 0) {
                    queue.offer(destination);
                    visited[destination] = visited[current] + 1;
                }

                if (destination == 100) {
                    return visited[destination];
                }
            }
        }

        return 0;
    }
}