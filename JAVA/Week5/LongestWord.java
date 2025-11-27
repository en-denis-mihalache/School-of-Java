import java.util.*;

public class LongestWord {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "sternocleidomastoid");
        String longestWord = words.stream()
                .reduce("", (a, b) -> a.length() >= b.length() ? a : b);
        System.out.println("Longest word: " + longestWord);
    }

}
