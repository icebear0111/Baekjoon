import java.util.*;

public class Main {
    static int N, M;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();

                if (num == 1) homes.add(new int[]{i, j});
                if (num == 2) chickens.add(new int[]{i, j});
            }
        }

        visited = new boolean[chickens.size()];
        dfs(0, 0);
        
        System.out.println(min);
    }
    
    static void dfs(int start, int count) {
        if (count == M) {
            min = Math.min(min, calculate());
            return;
        }
        
        for (int i = start; i < chickens.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
    
    static int calculate() {
        int total = 0;
        
        for (int[] home : homes) {
            int distance = Integer.MAX_VALUE;
            
            for (int i = 0; i < chickens.size(); i++) {
                if (visited[i]) {
                    int[] chicken = chickens.get(i);
                    distance = Math.min(distance, Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]));
                }
            }
            
            total += distance;
        }
        
        return total;
    }
}