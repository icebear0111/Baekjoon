import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] paper;
    static int white, blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 0, N);

        System.out.println(white + "\n" + blue);
    }

    static void search(int row, int column, int range) {
        if (check(row, column, range)) {
            if (paper[row][column] == 0)
                white++;
            else
                blue++;

            return;
        }

        int newRange = range / 2;

        search(row, column, newRange);
        search(row, column + newRange, newRange);
        search(row + newRange, column, newRange);
        search(row + newRange, column + newRange, newRange);
    }

    static boolean check(int row, int column, int range) {
        for (int i = row; i < row + range; i++) {
            for (int j = column; j < column + range; j++) {
                if (paper[i][j] != paper[row][column]) {
                    return false;
                }
            }
        }

        return true;
    }
}