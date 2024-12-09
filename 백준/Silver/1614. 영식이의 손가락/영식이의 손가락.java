import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        long n = sc.nextLong();

        long result;

        if (start == 1 || start == 5)
            result = n * 8 + (start == 1 ? 0 : 4);
        else if (start == 2) {
            if (n % 2 == 0)
                result = n * 4 + 1;
            else
                result = n * 4 + 3;
        }
        else if (start == 3)
            result = n * 4 + 2;
        else {
            if (n % 2 == 0)
                result = n * 4 + 3;
            else
                result = n * 4 + 1;
        }

        System.out.println(result);
    }
}