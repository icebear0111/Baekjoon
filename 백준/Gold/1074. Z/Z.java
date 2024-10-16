import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);

        int answer = 0;
        int x = 0, y = 0;
        while (size > 1) {
            size /= 2;
            int half = size * size;
            
            if (r < x + size && c < y + size) { // 1사분면
                answer += half * 0;
            }
            else if (r < x + size) { // 2사분면
                answer += half * 1;
                y += size;
            }
            else if (c < y + size) { // 3사분면
                answer += half * 2;
                x += size;
            }
            else {
                answer += half * 3; // 4사분면
                x += size;
                y += size;
            }
        }
        
        bw.write(answer + "\n");
        bw.flush();
    }
}
