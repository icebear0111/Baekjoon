import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] maze, distance;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        distance = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                maze[i][j] = input.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        bw.write((distance[N - 1][M - 1] + 1) + "\n");
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
                if (visited[nextX][nextY] || maze[nextX][nextY] == 0) {
                    continue;
                }

                queue.offer(new int[]{nextX, nextY});
                visited[nextX][nextY] = true;
                distance[nextX][nextY] = distance[currentX][currentY] + 1;
            }
        }
    }
}
