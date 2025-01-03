import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] temp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxArea = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        buildWall(0);
        System.out.println(maxArea);
    }

    static void buildWall(int count) {
        if (count == 3) {
            spreadVirus();
            maxArea = Math.max(maxArea, getArea());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void spreadVirus() {
        Queue<int[]> queue = new LinkedList<>();
        temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
                if (temp[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }

    static int getArea() {
        int area = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    area++;
                }
            }
        }

        return area;
    }
}