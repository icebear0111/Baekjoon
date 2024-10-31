import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] answer = new String[10000];

            queue.add(A);
            visited[A] = true;
            Arrays.fill(answer, "");

            while (!queue.isEmpty() && !visited[B]) {
                int current = queue.poll();
                int D = (current * 2) % 10000;
                int S = (current == 0) ? 9999 : current - 1;
                int L = (current % 1000) * 10 + current / 1000;
                int R = (current % 10) * 1000 + current / 10;

                if (!visited[D]) {
                    queue.add(D);
                    visited[D] = true;
                    answer[D] = answer[current] + "D";
                }
                if (!visited[S]) {
                    queue.add(S);
                    visited[S] = true;
                    answer[S] = answer[current] + "S";
                }
                if (!visited[L]) {
                    queue.add(L);
                    visited[L] = true;
                    answer[L] = answer[current] + "L";
                }
                if (!visited[R]) {
                    queue.add(R);
                    visited[R] = true;
                    answer[R] = answer[current] + "R";
                }
            }
            bw.write(answer[B] + "\n");
        }
        bw.flush();
    }
}