import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] tomato;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tomato = new int[M][N];
        visited = new boolean[M][N];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = bfs();
        
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int day = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomato[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currentI = current[0];
                int currentJ = current[1];
                for (int d = 0; d < 4; d++) {
                    int x = currentI + dx[d];
                    int y = currentJ + dy[d];
                    if (x >= 0 && y >= 0 && x < M && y < N) {
                        if (tomato[x][y] == 0 && !visited[x][y]) {
                            queue.add(new int[]{x, y});
                            visited[x][y] = true;
                            tomato[x][y] = 1;
                        }
                    }
                }
            }
            day += 1;
        }
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomato[i][j] == 0) {
                    return -1;
                }
            }
        }
        
        return day - 1;
    }
}