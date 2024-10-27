import java.util.*;
import java.io.*;

public class Main {

    static int N, M, H;
    static int[][][] tomato;
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[H][M][N];
        visited = new boolean[H][M][N];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int answer = bfs();

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    public static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (tomato[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        int day = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int currentI = current[0];
                int currentJ = current[1];
                int currentK = current[2];
                for (int j = 0; j < 6; j++) {
                    int x = currentI + dx[j];
                    int y = currentJ + dy[j];
                    int z = currentK + dz[j];
                    if (x >= 0 && y >= 0 && z >= 0 && x < H && y < M && z < N) {
                        if (tomato[x][y][z] == 0 && !visited[x][y][z]) {
                            queue.add(new int[]{x, y, z});
                            visited[x][y][z] = true;
                            tomato[x][y][z] = 1;
                        }
                    }
                }
            }
            day += 1;
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (tomato[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        return day - 1;
    }
}