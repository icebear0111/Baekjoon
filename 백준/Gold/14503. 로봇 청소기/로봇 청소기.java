import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] room = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        int[] dx = {-1, 0, 1, 0}; // d: 0 = 북, 1 = 동, 2 = 남, 3 = 서
        int[] dy = {0, 1, 0, -1};

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            if (!visited[r][c]) {
                visited[r][c] = true;
                answer++;
            }

            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (room[nx][ny] == 0 && !visited[nx][ny]) {
                    r = nx;
                    c = ny;
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                int nx = r - dx[d];
                int ny = c - dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || room[nx][ny] == 1) break;
                r = nx;
                c = ny;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
    }
}