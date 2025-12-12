import java.util.Scanner;

public class TemperatureConverter {
    public static double toCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    public static double toFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        double temp = scanner.nextDouble();
        System.out.print("Do you want to convert this temperature to (C)elsius or (F)ahrenheit? ");
        char scale = scanner.next().toUpperCase().charAt(0);

        if (scale == 'F') 
        {
            double celsius = TemperatureConverter.toCelsius(temp);
            System.out.printf("%.2f Fahrenheit is %.2f Celsius%n", temp, celsius);
        } else if (scale == 'C') {
            double fahrenheit = TemperatureConverter.toFahrenheit(temp);
            System.out.printf("%.2f Celsius is %.2f Fahrenheit%n", temp, fahrenheit);
        } else {
            System.out.println("Invalid scale. Please enter 'C' or 'F'.");
        }
    }
}