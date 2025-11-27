import java.util.*;

public class SumOfSquares {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int suma = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Sum of squares: " + suma);
    }
}