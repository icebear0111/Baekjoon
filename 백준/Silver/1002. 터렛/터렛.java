import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            if (x1 == x2 && y1 == y2 && r1 == r2)
                sb.append("-1\n");
            else if (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) > Math.pow(r2 + r1, 2))
                sb.append("0\n");
            else if (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) < Math.pow(r2 - r1, 2))
                sb.append("0\n");
            else if (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) == Math.pow(r2 - r1, 2))
                sb.append("1\n");
            else if (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) == Math.pow(r2 + r1, 2))
                sb.append("1\n");
            else
                sb.append("2\n");
        }

        System.out.print(sb);
    }
}