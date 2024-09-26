import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int[] arr = new int[3];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            }
            
            Arrays.sort(arr);
            int a = arr[0] * arr[0];
            int b = arr[1] * arr[1];
            int c = arr[2] * arr[2];
            
            if (a + b == c) {
                System.out.println("right");
            }
            else {
                System.out.println("wrong");
            }

        }
    }
}