import java.util.*;
import java.io.*;

public class Main {

    static char[] str1;
    static char[] str2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();

        dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        bw.write(LCS(str1.length - 1, str2.length - 1) + "");
        bw.flush();
    }

    static int LCS(int x, int y) {
        // 인덱스 밖
        if (x == -1 || y == -1) return 0;

        // 탐색하지 않은 인덱스
        if (dp[x][y] == -1) {
            dp[x][y] = 0;

            if (str1[x] == str2[y]) {
                dp[x][y] = LCS(x - 1, y - 1) + 1;
            }
            else {
                dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
            }
        }

        return dp[x][y];
    }
}