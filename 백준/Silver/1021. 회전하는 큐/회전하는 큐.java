import java.util.*;

public class Main {
    static Deque<Integer> a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = new ArrayDeque<>();

        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            a.add(i);
        }

        int M = sc.nextInt();
        int count = 0;
        for (int i = 0; i < M; i++) {
            int pos = sc.nextInt();
            while(true) {
                if (a.peek() != null&& a.peek().equals(pos)) {
                    a.poll();
                    break;
                }
                else {
                    List<Integer> list = new ArrayList<>(a);
                    int idx = list.indexOf(pos);

                    if (idx <= a.size() / 2)
                        a.addLast(a.pollFirst());
                    else
                        a.addFirst(a.pollLast());

                    count++;
                }
            }
        }

        System.out.println(count);
    }
}