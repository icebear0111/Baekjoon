import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int num = 1;
        while (true) {
            if (!stack.isEmpty() && stack.peek() == arr[index]) {
                stack.pop();
                sb.append("-\n");
                index++;
            }
            else if (num <= n) {
                stack.push(num);
                sb.append("+\n");
                num++;
            }
            else {
                break;
            }
        }

        if (!stack.isEmpty()) {
            sb.setLength(0);
            sb.append("NO");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}