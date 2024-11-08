import java.util.*;
import java.io.*;

public class Main {

    static int RED = 0;
    static int GREEN = 1;
    static int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] Cost = new int[N][N];
        int[][] DP = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Cost[i][RED] = Integer.parseInt(st.nextToken());
            Cost[i][GREEN] = Integer.parseInt(st.nextToken());
            Cost[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        DP[0][RED] = Cost[0][RED];
        DP[0][GREEN] = Cost[0][GREEN];
        DP[0][BLUE] = Cost[0][BLUE];

        for (int i = 1; i < N; i++) {
            DP[i][RED] = Math.min(DP[i - 1][GREEN], DP[i - 1][BLUE]) + Cost[i][RED];
            DP[i][GREEN] = Math.min(DP[i - 1][RED], DP[i - 1][BLUE]) + Cost[i][GREEN];
            DP[i][BLUE] = Math.min(DP[i - 1][RED], DP[i - 1][GREEN]) + Cost[i][BLUE];
        }

        bw.write(Math.min(DP[N - 1][RED], Math.min(DP[N - 1][GREEN], DP[N - 1][BLUE])) + "");
        bw.flush();
    }
}