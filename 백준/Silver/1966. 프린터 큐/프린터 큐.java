import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                queue.offer(new int[] { i, Integer.parseInt(st.nextToken())});
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int[] front = queue.poll();
                boolean flag = true;

                for (int i = 0; i < queue.size(); i++) {
                    if (front[1] < queue.get(i)[1]) {
                        queue.offer(front);
                        for (int j = 0; j < i; j++) {
                            queue.offer(queue.poll());
                        }
                        flag = false;
                        break;
                    }
                }

                if (!flag){
                    continue;
                }

                count++;
                if (front[0] == M) {
                    break;
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
    }
}