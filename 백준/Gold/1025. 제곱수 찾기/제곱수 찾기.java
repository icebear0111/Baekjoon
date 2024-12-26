import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        char[][] A = new char[N][M];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLine().toCharArray();
        }

        int max = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int di = -N; di < N; di++) {
                    for (int dj = -M; dj < M; dj++) {
                        if (di == 0 && dj == 0) continue;

                        int num = 0;
                        int x = i;
                        int y = j;

                        while (x >= 0 && x < N && y >= 0 && y < M) {
                            num = num * 10 + (A[x][y] - '0');

                            if (isSquare(num)) {
                                max = Math.max(max, num);
                            }

                            x += di;
                            y += dj;
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }

    private static boolean isSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}