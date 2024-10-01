import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(i + 1);
        }

        bw.write("<");

        int count = 1;
        while (!queue.isEmpty()) {
            if (count != K) {
                queue.offer(queue.poll());
                count++;
            }
            else {
                bw.write(String.valueOf(queue.poll()));
                if (!queue.isEmpty()) {
                    bw.write(", ");
                }
                count = 1;
            }
        }
        bw.write(">");
        bw.flush();
    }
}