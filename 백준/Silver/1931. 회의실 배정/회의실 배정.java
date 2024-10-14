import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] times = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int start = times[0][0], end = times[0][1];
        int answer = 1;
        for (int i = 1; i < N; i++) {
            int compareStart = times[i][0], compareEnd = times[i][1];
            if (compareEnd < end) {
                start = compareStart;
                end = compareEnd;
                continue;
            }
            if (compareStart < end) {
                continue;
            }
            answer += 1;
            start = compareStart;
            end = compareEnd;
        }
        
        System.out.println(answer);
    }
}
