import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long answer = pow(A, B, C);
        bw.write(answer + "");
        bw.flush();
    }

    public static long pow(int A, int B, int C) {
        if (B == 0) {
            return 1;
        }
        else if (B == 1) {
            return A % C;
        }
        else if (B % 2 == 0) {
            long temp = pow(A, B / 2, C);
            return (temp * temp) % C;
        }
        else {
            long temp = pow(A, (B - 1) / 2, C);
            return (temp * temp % C) * A % C;
        }
    }
}