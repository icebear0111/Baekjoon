import java.util.*;

public class Main {
    static int l;
    static int[][] chess;
    static boolean[][] visited;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            l = sc.nextInt();
            chess = new int[l][l];
            visited = new boolean[l][l];

            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            System.out.println(bfs(x1, y1, x2, y2));
        }
    }

    public static int bfs(int x1, int y1, int x2, int y2) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x1, y1});
        visited[x1][y1] = true;
        count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                if (current[0] == x2 && current[1] == y2) {
                    return count;
                }

                for (int j = 0; j < 8; j++) {
                    int nx = current[0] + dx[j];
                    int ny = current[1] + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < l && ny < l) {
                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            queue.add(new int[] {nx, ny});
                        }
                    }
                }
            }
            count++;
        }

        return 0;
    }
}