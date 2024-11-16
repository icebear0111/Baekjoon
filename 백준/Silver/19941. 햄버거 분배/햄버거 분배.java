import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                for (int j = -K; j <= K; j++) {
                    if (i + j < 0) continue;
                    if (i + j >= N) break;

                    if (arr[i + j] == 'H') {
                        arr[i + j] = 'X';
                        answer++;
                        break;
                    }
                }
            }
        }

        bw.write(answer + "");
        bw.flush();
    }
}