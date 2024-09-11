import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][3];
        int rank = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int id = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            arr[id - 1][0] = gold;
            arr[id - 1][1] = silver;
            arr[id - 1][2] = bronze;
        }

        for (int i = 0; i < N; i++) {
            if (arr[i][0] > arr[K - 1][0])
                rank++;
            else if (arr[i][0] == arr[K - 1][0] && arr[i][1] > arr[K - 1][1])
                rank++;
            else if (arr[i][0] == arr[K - 1][0] && arr[i][1] == arr[K - 1][1] && arr[i][2] > arr[K - 1][2])
                rank++;
        }

        System.out.println(rank);
    }
}
