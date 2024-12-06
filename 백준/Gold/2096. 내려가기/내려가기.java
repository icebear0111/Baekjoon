import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N][3];
        int[][] maxDp = new int[N][3];
        int[][] minDp = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        maxDp[0][0] = minDp[0][0] = arr[0][0];
        maxDp[0][1] = minDp[0][1] = arr[0][1];
        maxDp[0][2] = minDp[0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    maxDp[i][j] = Math.max(maxDp[i - 1][j], maxDp[i - 1][j + 1]) + arr[i][j];
                    minDp[i][j] = Math.min(minDp[i - 1][j], minDp[i - 1][j + 1]) + arr[i][j];
                }
                else if (j == 1) {
                    maxDp[i][j] = Math.max(maxDp[i - 1][j - 1], Math.max(maxDp[i - 1][j], maxDp[i - 1][j + 1])) + arr[i][j];
                    minDp[i][j] = Math.min(minDp[i - 1][j - 1], Math.min(minDp[i - 1][j], minDp[i - 1][j + 1])) + arr[i][j];
                }
                else {
                    maxDp[i][j] = Math.max(maxDp[i - 1][j - 1], maxDp[i - 1][j]) + arr[i][j];
                    minDp[i][j] = Math.min(minDp[i - 1][j - 1], minDp[i - 1][j]) + arr[i][j];
                }
            }
        }

        int maxResult = Math.max(maxDp[N - 1][0], Math.max(maxDp[N - 1][1], maxDp[N - 1][2]));
        int minResult = Math.min(minDp[N - 1][0], Math.min(minDp[N - 1][1], minDp[N - 1][2]));

        System.out.println(maxResult + " " + minResult);
    }
}