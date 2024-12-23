import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사람 수
        int M = sc.nextInt(); // 파티 수

        if (M == 0) {
            System.out.println(0);
            return;
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int truth = sc.nextInt(); // 진실을 아는 사람 수
        Set<Integer> truthPeople = new HashSet<>();

        if (truth == 0) {
            System.out.println(M);
            return;
        }

        for (int i = 0; i < truth; i++) {
            truthPeople.add(sc.nextInt());
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int partySize = sc.nextInt();
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < partySize; j++) {
                party.add(sc.nextInt());
            }
            parties.add(party);

            if (party.size() == 1) continue;
            for (int j = 1; j < party.size(); j++) {
                union(party.get(0), party.get(j));
            }
        }

        Set<Integer> updatedTruthPeople = new HashSet<>();
        for (int person : truthPeople) {
            updatedTruthPeople.add(find(person));
        }
        truthPeople = updatedTruthPeople;

        int count = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (truthPeople.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) count++;
        }

        System.out.println(count);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
}