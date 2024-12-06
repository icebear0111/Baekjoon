import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int[] firstDigit = {2, 3, 5, 7}; // 제일 앞 숫자는 소수만 가능하기 때문에 2, 3, 5, 7로 시작하는 숫자만 고려
        for (int number : firstDigit) {
            search(number, 1);
        }
    }

    static void search(int number, int depth) {
        if (depth == N) System.out.println(number);

        int[] nextDigit = {1, 3, 7, 9}; // 0, 2, 4, 5, 6, 8은 앞의 숫자와 무관하게 무조건 소수가 아님
        for (int digit : nextDigit) {
            int nextNumber = number * 10 + digit;

            if (isPrime(nextNumber)) search(nextNumber, depth + 1);
        }
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}