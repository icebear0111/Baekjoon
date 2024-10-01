import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] eratosthenes = new int[1000001];
        for (int i = 2; i < 1000000; i++) {
            eratosthenes[i] = i;
        }

        for (int i = 2; i < 1000000; i++) {
            if (eratosthenes[i] == 0) continue;

            for (int j = 2 * i; j <= 1000000; j += i) {
                eratosthenes[j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (eratosthenes[i] != 0) bw.write(eratosthenes[i] + "\n");
        }
        bw.flush();
    }
}