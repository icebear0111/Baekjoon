import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder[] arr = new StringBuilder[201]; // 나이의 범위: 1 ~ 200
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new StringBuilder();
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr[age].append(age).append(" ").append(name).append("\n"); // 카운팅 정렬
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() != 0) {
                System.out.print(arr[i]);
            }
        }
    }
}