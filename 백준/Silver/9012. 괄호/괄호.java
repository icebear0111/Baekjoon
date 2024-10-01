import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        String input = "";
        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            input = br.readLine();
            boolean flag = true;
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);

                if (c == '(') {
                    stack.push(c);
                }

                if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                    }
                    else {
                        stack.pop();
                    }
                }
            }
            if (flag && stack.isEmpty()) {
                bw.write("YES\n");
            }
            else {
                bw.write("NO\n");
            }
        }
        bw.flush();
    }
}