import java.util.*;

public class Main {
    static int K, W, H;
    static int[][] matrix;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();
        matrix = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        if (matrix[0][0] == 1 || matrix[H - 1][W - 1] == 1) {
            System.out.println(-1);
            return;
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, K});
        visited[0][0][K] = true;

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int remainingK = current[2];

                if (x == H - 1 && y == W - 1) {
                    return time;
                }
                
                if (remainingK > 0) {
                    for (int j = 0; j < 8; j++) {
                        int nx = x + hx[j];
                        int ny = y + hy[j];

                        if (nx < 0 || nx >= H || ny < 0 || ny >= W)
                            continue;

                        if (matrix[nx][ny] == 0 && !visited[nx][ny][remainingK - 1]) {
                            queue.offer(new int[]{nx, ny, remainingK - 1});
                            visited[nx][ny][remainingK - 1] = true;
                        }
                    }
                }
                
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx < 0 || nx >= H || ny < 0 || ny >= W)
                        continue;

                    if (matrix[nx][ny] == 0 && !visited[nx][ny][remainingK]) {
                        queue.offer(new int[]{nx, ny, remainingK});
                        visited[nx][ny][remainingK] = true;
                    }
                }
            }

            time++;
        }

        return -1;
    }
}