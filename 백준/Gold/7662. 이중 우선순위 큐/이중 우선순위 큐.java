import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                String[] inputs = br.readLine().split(" ");
                if (inputs[0].equals("I")) {
                    int num = Integer.parseInt(inputs[1]);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                else {
                    if (map.isEmpty()) continue;

                    if (inputs[1].equals("1")) {
                        int maxKey = map.lastKey();
                        if (map.get(maxKey) == 1)
                            map.remove(maxKey);
                        else
                            map.put(maxKey, map.get(maxKey) - 1);
                    }
                    else {
                        int minKey = map.firstKey();
                        if (map.get(minKey) == 1)
                            map.remove(minKey);
                        else
                            map.put(minKey, map.get(minKey) - 1);
                    }
                }
            }
            if (map.isEmpty()) {
                bw.write("EMPTY\n");
            }
            else {
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }
        bw.flush();
    }
}