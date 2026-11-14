package week2;

import java.util.*;

public class WordFrequencyDemo {
    static void printFilteredWordFrequency(String feedback) {
        Set<String> stopWords = new HashSet<>(Arrays.asList(
                "the","was","and","a","is","of","in"
        ));

        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = cleaned.split("\\s+");
        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            if (!stopWords.contains(word)) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(feedback);
    }
}
