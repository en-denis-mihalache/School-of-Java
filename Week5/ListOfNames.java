import java.util.*;
import java.util.stream.Collectors;

public class ListOfNames{
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Bob", "Dani", "Charlie", "Alex", "Eve");
        var sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNames);
    }
}