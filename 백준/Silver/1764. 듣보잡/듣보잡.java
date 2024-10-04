import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N + M; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        ArrayList<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 2) {
                list.add(key);
            }
        }
        Collections.sort(list);

        bw.write(list.size() + "\n");
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + "\n");
        }
        bw.flush();
    }
}