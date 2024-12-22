import java.util.*;

public class Main {
    static boolean[] broken = new boolean[10]; // 고장난 버튼을 체크할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int button = sc.nextInt();
            broken[button] = true; // 고장난 버튼은 true로 설정
        }

        if (N == 100) { // 시작 채널이 100이므로 목표 채널이 100이면 0 출력
            System.out.println(0);
            return;
        }

        int min = Math.abs(N - 100); // 초기 설정은 100에서 목표로 하는 채널까지의 거리

        for (int i = 0; i <= 1000000; i++) {
            int len = possible(i); // i번째 채널을 입력 가능한지 체크
            if (len > 0) { // 입력 가능하다면
                int press = Math.abs(i - N); // i번째 채널에서 목표 채널까지의 거리
                min = Math.min(min, len + press); // 최솟값 갱신
            }
        }

        System.out.println(min);
    }

    static int possible(int n) {
        if (n == 0) {
            if (broken[0]) {
                return 0;
            }
            else {
                return 1;
            }
        }

        int len = 0;
        while (n > 0) {
            if (broken[n % 10]) { // 고장난 버튼이 있으면 실패 => 0 리턴
                return 0;
            }
            len += 1;
            n /= 10;
        }

        return len; // 버튼 입력 길이
    }
}