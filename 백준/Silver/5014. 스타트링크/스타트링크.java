import java.util.*;
import java.io.*;

public class Main {
    static int F, S, G, U, D;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();
        dp = new int[F + 1];

        int answer = bfs();
        if (answer == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        dp[S] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == G) {
                return dp[current] - 1;
            }

            if (current + U <= F && dp[current + U] == 0) {
                dp[current + U] = dp[current] + 1;
                queue.add(current + U);
            }

            if (current - D >= 1 && dp[current - D] == 0) {
                dp[current - D] = dp[current] + 1;
                queue.add(current - D);
            }
        }

        return -1;
    }
}