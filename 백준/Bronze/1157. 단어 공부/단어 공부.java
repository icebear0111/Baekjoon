import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String word = br.readLine().toUpperCase();

        int[] arr = new int[26];
        int max = 0;
        char answer = '?';
        
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 65]++;
            if (max < arr[word.charAt(i) - 65]) {
                max = arr[word.charAt(i) - 65];
                answer = word.charAt(i);
            } else if (max == arr[word.charAt(i) - 65]) {
                answer = '?';
            }
        }
        
        System.out.println(answer);
    }
}
