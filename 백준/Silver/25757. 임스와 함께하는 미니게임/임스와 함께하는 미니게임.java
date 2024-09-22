import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            set.add(name);
        }

        int answer = 0;
        if (game.equals("Y")) {
            answer = set.size();
        }
        if (game.equals("F")) {
            answer = set.size() / 2;
        }
        if (game.equals("O")) {
            answer = set.size() / 3;
        }

        System.out.println(answer);
    }
}