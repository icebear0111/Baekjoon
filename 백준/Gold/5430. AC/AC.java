import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");

            Deque<Integer> deque = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                deque.add(Integer.parseInt(arr[j]));
            }

            boolean isReverse = false;
            boolean isError = false;

            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R') {
                    isReverse = !isReverse;
                }
                else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReverse) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (isError) {
                bw.write("error\n");
            }
            else {
                bw.write("[");
                if (!deque.isEmpty()) {
                    if (isReverse) {
                        bw.write(deque.pollLast() + "");
                        while (!deque.isEmpty()) {
                            bw.write("," + deque.pollLast());
                        }
                    } else {
                        bw.write(deque.pollFirst() + "");
                        while (!deque.isEmpty()) {
                            bw.write("," + deque.pollFirst());
                        }
                    }
                }
                bw.write("]\n");
            }
        }
        bw.flush();
        bw.close();
    }
}