import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.partitioningBy;

public class EvensAndOdds {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
        var partitionedNumbers = numbers.stream()
                .collect(partitioningBy(n -> n % 2 == 0));
        System.out.println("Even numbers : " + partitionedNumbers.values(true));
        System.out.println("Odd numbers : " + partitionedNumbers.values(false));
    }
}