import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : list) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        LinkedHashMap<Integer, Integer> resultMap = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int count = map.getOrDefault(num, 0);
            bw.write(count + " ");
        }
        bw.flush();
    }
}