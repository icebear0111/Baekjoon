import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int r = 31;
        int M = 1234567891;
        long sum = 0;
        long pow = 1;
        char[] ch = br.readLine().toCharArray();
        for(int i = 0; i < L; i++){
            sum += (ch[i] - 'a' + 1) * pow;
            sum %= M;
            pow *= r;
            pow %= M;
        }
        System.out.println(sum);
    }
}