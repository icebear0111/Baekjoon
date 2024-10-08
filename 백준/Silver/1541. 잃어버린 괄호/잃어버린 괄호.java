import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        String[] expression = br.readLine().split("-");

        for (int i = 0; i < expression.length; i++) {
            int sum = 0;
            String[] part = expression[i].split("\\+");

            for (int j = 0; j < part.length; j++) {
                sum += Integer.parseInt(part[j]);
            }

            if (i == 0) total = sum;
            else total -= sum;
        }

        System.out.println(total);
    }
}