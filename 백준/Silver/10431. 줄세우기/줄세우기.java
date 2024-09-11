import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int key = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            int count = 0;

            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < j; k++) {
                    if (arr[j] < arr[k]) count++;
                }
            }

            System.out.println(key + " " + count);
        }
    }
}
