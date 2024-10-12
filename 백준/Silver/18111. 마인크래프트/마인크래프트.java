import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int inven = Integer.parseInt(st.nextToken());
        int[][] minecraft =  new int[N][M];

        int max = 0;
        int min = 256;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                minecraft[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, minecraft[i][j]);
                min = Math.min(min, minecraft[i][j]);
            }
        }

        int minSeconds = Integer.MAX_VALUE;
        int maxHeight = 0;
        for (int i = min; i <= max; i++) {
            int seconds = 0;
            int invenTemp = inven;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (minecraft[j][k] > i) {
                        seconds += 2 * (minecraft[j][k] - i);
                        invenTemp += minecraft[j][k] - i;
                    }
                    else if (minecraft[j][k] < i) {
                        seconds += i - minecraft[j][k];
                        invenTemp -= i - minecraft[j][k];
                    }
                }
            }

            if (invenTemp < 0)
                continue;

            if (seconds <= minSeconds) {
                minSeconds = seconds;
                maxHeight = Math.max(maxHeight, i);
            }
        }

        System.out.println(minSeconds + " " + maxHeight);
    }
}
