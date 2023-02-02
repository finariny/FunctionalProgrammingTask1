import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTopWords = 10;

        String string = scanner.nextLine();

        String[] arrayOfWords = string.split(" +");
        Set<String> arrayWithoutDuplicates = new HashSet<>(Arrays.asList(arrayOfWords));

        System.out.println("В тексте " + arrayWithoutDuplicates.size() + " слов");

        System.out.println("TOP " + numberOfTopWords + ":");

        Map<String, Integer> mapOfWords = new TreeMap<>();

        for (String word : arrayOfWords) {
            if (!mapOfWords.containsKey(word)) {
                mapOfWords.put(word, 1);
            } else {
                mapOfWords.put(word, mapOfWords.get(word) + 1);
            }
        }

        mapOfWords.entrySet().stream()
                .limit(numberOfTopWords)
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getValue() + " - " + entry.getKey()));
    }
}