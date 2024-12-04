import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        char oddChar = 0;
        for (char c : list) {
            int count = map.get(c);
            if (count % 2 == 1) {
                if (oddChar != 0) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                oddChar = c;
            }
            for (int i = 0; i < count / 2; i++) {
                sb.append(c);
                sb2.insert(0, c);
            }
        }

        if (oddChar != 0) {
            sb.append(oddChar);
        }

        sb.append(sb2);
        System.out.println(sb);
    }
}