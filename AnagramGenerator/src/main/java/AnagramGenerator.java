import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnagramGenerator {

    /**
     * Generates all possible anagrams of the given string.
     *
     * @param input A string of distinct letters.
     * @return A list of all anagrams of the input string.
     * @throws IllegalArgumentException if the input is null, empty, or contains non-letter characters.
     */
    public static List<String> generateAnagrams(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input must be a non-empty string.");
        }
        if (!input.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Input must contain only letters.");
        }

        List<String> anagrams = new ArrayList<>();
        generateAnagramsHelper("", input, anagrams);
        return anagrams;
    }

    /**
     * Helper method to recursively generate anagrams.
     *
     * @param prefix The current prefix being built.
     * @param remaining The remaining letters to process.
     * @param anagrams The list to store generated anagrams.
     */
    private static void generateAnagramsHelper(String prefix, String remaining, List<String> anagrams) {
        if (remaining.isEmpty()) {
            anagrams.add(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String newPrefix = prefix + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generateAnagramsHelper(newPrefix, newRemaining, anagrams);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string of distinct letters to generate anagrams:");
        String input = scanner.nextLine();

        try {
            List<String> anagrams = generateAnagrams(input);
            System.out.println("Anagrams of '" + input + "': " + anagrams);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
