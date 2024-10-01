import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int num = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                num = Integer.parseInt(st.nextToken()); // 마지막으로 추가한 값을 저장
                queue.offer(num);
            }
            if (command.equals("pop")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(queue.poll() + "\n");
                }
            }
            if (command.equals("size")) {
                bw.write(queue.size() + "\n");
            }
            if (command.equals("empty")) {
                if (queue.isEmpty()) {
                    bw.write("1\n");
                }
                else {
                    bw.write("0\n");
                }
            }
            if (command.equals("front")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(queue.peek() + "\n");
                }
            }
            if (command.equals("back")) {
                if (queue.isEmpty()) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(num + "\n"); // = 마지막으로 push 한 숫지
                }
            }
        }
        bw.flush();
    }
}