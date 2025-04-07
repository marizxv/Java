import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// task 6

public class IleSlowILiter{
    public static void main(String[] args) {
        System.out.println("I count words and letters in a sentence, please enter yours: ");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine().trim();

        int wordCount = 0;
        int letterCount = 0;

        // Split the sentence into words based on spaces
        String[] words = sentence.split("\\s+");
        Map<Character, Integer> liczbaLiter = new HashMap<Character, Integer>();
        // Iterate over each word
        for (String word : words) {
            // Remove special characters from the word (anything non-letter)
            word = word.replaceAll("[^a-zA-Z]", "");

            // If the word is not empty after removing special characters, count it
            if (!word.isEmpty()) {
                wordCount++;

                // Count the number of letters in the word
                letterCount += word.length();

                for (char c : word.toLowerCase().toCharArray()) {
                    liczbaLiter.put(c, liczbaLiter.getOrDefault(c,0) + 1);
                }
            }
        }

        // Output the results
        System.out.println("Number of words: " + wordCount);
        System.out.println("Number of letters: " + letterCount);

        for (char c = 'a'; c <= 'z'; c++) {
            if (liczbaLiter.containsKey(c)) {
                System.out.println(c+":"+liczbaLiter.get(c));
            }
        }
        scanner.close();
    }
}