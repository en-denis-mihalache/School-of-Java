import java.util.*;
import java.util.stream.Collectors;

public class SentancesToWords {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Hello world",
                "Java programming is fun",
                "Streams are powerful",
                "Hello Java"
        );

        List<String> words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(words);
    }
}