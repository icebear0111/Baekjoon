import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String input = "";
        while (true) {
            input = br.readLine();
            stack.clear();
            if (Objects.equals(input, ".")) {
                break;
            }
            boolean flag = true;
            for (int i = 0; i < input.length(); i++) {
                if (Objects.equals(input.charAt(i), '(') || Objects.equals(input.charAt(i), '[')) {
                    stack.push(String.valueOf(input.charAt(i)));
                }
                if (Objects.equals(input.charAt(i), ')')) {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if (Objects.equals(stack.pop(), "(")) {
                        continue;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
                if (Objects.equals(input.charAt(i), ']')) {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    }
                    if (Objects.equals(stack.pop(), "[")) {
                        continue;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (stack.isEmpty()) {
                if (flag) {
                    sb.append("yes\n");
                }
                else {
                    sb.append("no\n");
                }
            }
            else {
                sb.append("no\n");
            }
        }
        System.out.println(sb);
    }
}