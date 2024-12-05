import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int result = 0;
        while (A < B) {
            if (B % 2 == 0) {
                B /= 2;
            }
            else if (B % 10 == 1) {
                B /= 10;
            }
            else {
                break;
            }
            result++;
        }

        if (A == B) {
            System.out.println(result + 1);
        } else {
            System.out.println(-1);
        }
    }
}