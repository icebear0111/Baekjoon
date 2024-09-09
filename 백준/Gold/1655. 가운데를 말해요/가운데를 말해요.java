import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (maxHeap.size() == minHeap.size()) {
                maxHeap.offer(num);
            }
            else {
                minHeap.offer(num);
            }

            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    int tmp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(tmp);
                }
            }

            System.out.println(maxHeap.peek());
        }
    }
}
