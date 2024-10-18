import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];
        visited = new boolean[N][M];

        int x = 0;
        int y = 0;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = input.charAt(j);

                if (campus[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y);

        if (count == 0) {
            bw.write("TT");
        } else {
            bw.write(Integer.toString(count));
        }

        bw.flush();
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                if (campus[nextX][nextY] == 'X') {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }

                queue.offer(new int[]{nextX, nextY});
                if (campus[nextX][nextY] == 'P') {
                    count++;
                }
                visited[nextX][nextY] = true;
            }
        }
    }
}
