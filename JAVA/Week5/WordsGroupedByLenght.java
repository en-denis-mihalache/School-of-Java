import java.util.*;
import java.util.stream.Collectors;

public class WordsGroupedByLenght {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "bat", "car", "dolphin", "elephant", "frog", "goat");

        var groupedWords = words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(groupedWords);
    }
}