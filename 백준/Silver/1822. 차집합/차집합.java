import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int nA = sc.nextInt();
        int nB = sc.nextInt();

        HashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < nA; i++) {
            int num = sc.nextInt();
            map.put(num, 1);
        }

        for (int i = 0; i < nB; i++) {
            int num = sc.nextInt();
            if (map.containsKey(num))
                map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}