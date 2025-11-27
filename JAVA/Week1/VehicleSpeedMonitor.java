import java.util.Scanner;

public class VehicleSpeedMonitor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter vehicle type (Car, Bus, Bike): ");
            String type = sc.nextLine().trim();

            System.out.print("Enter speed: ");
            String speedLine = sc.nextLine().trim();

            int speed;
            if (!speedLine.matches("-?\\d+")) {
                System.out.println("Please enter a numeric speed.");
                continue;
            }
            
            speed = Integer.parseInt(speedLine);

            if (speed < 0) {
                System.out.println("Monitoring stopped.");
                break;
            }

            
            int limit = switch (type) {
                case String s when s.equalsIgnoreCase("car")  -> 100;
                case String s when s.equalsIgnoreCase("bus")  -> 80;
                case String s when s.equalsIgnoreCase("bike") -> 60;
                default -> -1;
            };

            
            if (limit < 0) {
                System.out.println("Unknown vehicle type");
                continue; 
            }

            if (speed <= limit) {
                System.out.println("Speed OK");
            } else {
                System.out.println("Speeding!");
            }
        }

        sc.close();
    }
}
