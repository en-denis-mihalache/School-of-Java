import java.util.*;
public class AverangeWordLenght {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "Diana", "Ethan");
        int namesLength = names.size();
        float average = names.stream()
                .mapToInt(String::length)
                .reduce(0, Integer::sum) / namesLength;
        System.out.println("Average word length: " + average);
    }
}