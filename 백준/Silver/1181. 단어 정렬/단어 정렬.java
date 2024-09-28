import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) { // 길이가 같은 경우
                if (arr[i].length() > arr[j].length()) { // 길이가 짧은 순으로
                    String tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }

                if (arr[i].length() == arr[j].length()) { // 사전 순으로
                    if (arr[i].compareTo(arr[j]) > 0) {
                        String tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
        }

        bw.write(arr[0] + "\n");
        for (int i = 1; i < N; i++) {
            if (arr[i].compareTo(arr[i - 1]) == 0) {
                continue;
            }
            bw.write(arr[i] + "\n");
        }
        bw.flush();
    }
}