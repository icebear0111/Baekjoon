import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        // A부터 B까지 이진수에서 1의 개수 합 구하기
        long totalOnes = countOnesInRange(A, B);
        System.out.println(totalOnes);
    }

    // A부터 B까지 이진수에서 1의 개수 합을 구하는 메소드
    public static long countOnesInRange(long A, long B) {
        return countOnesUpTo(B) - countOnesUpTo(A - 1);
    }

    // 1부터 N까지 이진수에서 1의 개수 합을 구하는 메소드
    public static long countOnesUpTo(long N) {
        long count = 0;
        long powerOfTwo = 1;

        while (powerOfTwo <= N) {
            // 현재 비트의 위치에서 1이 몇 번 나타나는지 계산
            long fullCycles = (N + 1) / (powerOfTwo * 2);
            long remainder = (N + 1) % (powerOfTwo * 2);
            count += fullCycles * powerOfTwo + Math.max(0, remainder - powerOfTwo);

            powerOfTwo *= 2;
        }

        return count;
    }
}