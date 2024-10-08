import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>(((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 > abs2) // 앞에 절댓값이 뒤에 절댓값보다 크면
                return abs1 - abs2;
            else if (abs1 == abs2) { // 절댓값이 같은 경우
                return o1 - o2; // 값 자체를 비교
            }
            else
                return -1;
        }));

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (heap.isEmpty()) {
                    bw.write("0\n");
                }
                else {
                    bw.write(heap.poll() + "\n");
                }
            }
            else {
                heap.add(x);
            }
        }
        bw.flush();
    }
}