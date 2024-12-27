import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int distance = y - x;

            int n = (int) Math.sqrt(distance);

            if (distance == n * n) {
                System.out.println(2 * n - 1);
            }
            else if (distance <= n * n + n) {
                System.out.println(2 * n);
            }
            else {
                System.out.println(2 * n + 1);
            }
        }
    }
}