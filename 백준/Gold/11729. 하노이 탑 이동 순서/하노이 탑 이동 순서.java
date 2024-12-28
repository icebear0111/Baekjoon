import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sb.append((1 << N) - 1 + "\n");

        hanoi(N, 1, 3, 2);

        System.out.println(sb.toString());
    }

    static void hanoi(int N, int from, int to, int via) {
        if (N == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }

        hanoi(N - 1, from, via, to);
        sb.append(from + " " + to + "\n");
        hanoi(N - 1, via, to, from);
    }
}