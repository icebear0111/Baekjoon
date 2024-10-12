import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] X = new int[N];
        int[] temp = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
            temp[i] = X[i];
        }

        Arrays.sort(temp);

        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], idx++);
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(map.get(X[i]) + " ");
        }

        bw.flush();
    }
}
