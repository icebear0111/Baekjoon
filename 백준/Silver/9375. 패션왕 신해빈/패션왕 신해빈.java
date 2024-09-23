import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>(); // <옷 종류, 갯수>로 저장

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 의상 이름은 고려하지 않는다.
                String category = st.nextToken();

                if (map.containsKey(category)) { // 옷 종류가 이미 존재한다면 매핑되어 있는 값을 가져와 +1 한다
                    map.put(category, map.get(category) + 1);
                }
                else { // 아니라면 새로운 종류로 추가한다
                    map.put(category, 1);
                }
            }

            int answer = 1;

            for (int value : map.values()) {
                answer *= (value + 1); // 한 종류의 옷을 입지 않는 경우를 포함하여 +1을 한 값을 곱해준다
            }

            System.out.println(answer - 1); // 완전히 알몸인 상태는 포함하지 않는다
        }

    }
}