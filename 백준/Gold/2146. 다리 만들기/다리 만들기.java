import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int islandNumber = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, islandNumber++);
                }
            }
        }

        int shortestBridge = Integer.MAX_VALUE;
        for (int i = 2; i < islandNumber; i++) {
            shortestBridge = Math.min(shortestBridge, bfs(i));
        }

        System.out.println(shortestBridge);
    }

    static void dfs(int x, int y, int label) {
        visited[x][y] = true;
        map[x][y] = label;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;

            if (map[nx][ny] == 1 && !visited[nx][ny])
                dfs(nx, ny, label);
        }
    }

    static int bfs(int islandLabel) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == islandLabel) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int depth = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                        continue;

                    if (map[nx][ny] != 0 && map[nx][ny] != islandLabel)
                        return depth;
                    
                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            depth++;
        }

        return -1;
    }
}