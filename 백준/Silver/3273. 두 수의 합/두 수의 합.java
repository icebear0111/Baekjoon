import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int num = x - arr[i];
            
            if (map.containsKey(num)) {
                count += map.get(num);
            }
            
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println(count);
    }
}