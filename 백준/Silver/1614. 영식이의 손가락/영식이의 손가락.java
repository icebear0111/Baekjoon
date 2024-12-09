import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int start = sc.nextInt();
        long n = sc.nextLong();

        long result;

        if (start == 1 || start == 5)
            result = n * 8 + (start == 1 ? 0 : 4);
        else if (start == 2)
            result = n * 4 + (n % 2 == 0 ? 1 : 3);
        else if (start == 3)
            result = n * 4 + 2;
        else
            result = n * 4 + (n % 2 == 0 ? 3 : 1);

        System.out.println(result);
    }
}