import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, maxCount = 0;
        
        for (int right = 0; right < N; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                
                left++;
            }
            
            maxCount = Math.max(maxCount, right - left + 1);
        }
        
        bw.write(String.valueOf(maxCount));
        bw.flush();
    }
}
