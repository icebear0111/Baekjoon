public class Main {
    public static void main(String[] args) {
        final int RANGE = 10001;
        boolean[] isNotSelfNumber = new boolean[10001];

        for (int i = 1; i < RANGE; i++) {
            int number = getNumber(i);

            if (number < 10001)
                isNotSelfNumber[number] = true;
        }

        for (int i = 1; i < RANGE; i++) {
            if (!isNotSelfNumber[i])
                System.out.println(i);
        }
    }

    public static int getNumber(int number) {
        int sum = number;

        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}