import java.util.*;

public class Main {
    static int[] parent;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;

        for (int i = 0; i < m; i++) {
            int oper = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (oper == 0)
                union(a, b);
            else {
                if (find(a) == find(b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }
    
    static int find(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b)
            parent[b] = a;
    }
}