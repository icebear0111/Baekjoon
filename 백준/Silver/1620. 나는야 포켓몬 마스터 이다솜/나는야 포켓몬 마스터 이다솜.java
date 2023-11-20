import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int numberOfPokemon = Integer.parseInt(input[0]);
        int numberOfQuestion = Integer.parseInt(input[1]);

        HashMap<Integer, String> integerMap = new HashMap<>();
        HashMap<String, Integer> stringMap = new HashMap<>();

        for (int i = 0; i < numberOfPokemon; i++) {
            String pokemonName = br.readLine();
            integerMap.put(i + 1, pokemonName);
            stringMap.put(pokemonName, i + 1);
        }

        for (int i = 0; i < numberOfQuestion; i++) {
            String guess = br.readLine();

            if (isNumber(guess)) {
                System.out.println(integerMap.get(Integer.parseInt(guess)));
            }
            else {
                System.out.println(stringMap.get(guess));
            }
        }
    }

    public static boolean isNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}