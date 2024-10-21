import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < input.length(); i += 2) {
            if (input.charAt(i) == 'A') {
                countA += input.charAt(i + 1);
            } else {
                countB += input.charAt(i + 1);
            }
        }
        
        if (countA > countB) {
            bw.write("A");
        } else {
            bw.write("B");
        }
        
        bw.flush();
        bw.close();
    }
}
