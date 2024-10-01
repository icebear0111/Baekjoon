import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int bound = (int)Math.round(n * 0.15);
        int sum = 0;
        for (int i = bound; i < n - bound; i++) {
            sum += arr[i];
        }
        int answer = (int)Math.round((double) sum / (n - (2 * bound)));
        bw.write(String.valueOf(answer));
        bw.flush();
    }
}