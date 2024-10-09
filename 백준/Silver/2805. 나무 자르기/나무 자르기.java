import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long[] tree = new long[N];

        long max = 0;
        long min = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(st.nextToken());

            if (max < tree[i])
                max = tree[i];
        }

        long sum = 0;
        long mid = 0;
        while (min < max) {
            sum = 0;
            mid = (min + max) / 2;

            for (int i = 0; i < N; i++) {
                if (tree[i] - mid > 0)
                    sum += (tree[i] - mid);
            }

            if (sum < M) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}