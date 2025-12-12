package app;

import java.util.Scanner;

public class ConsoleIO {

    public static final String FORMAT = "[%s] %s";
    public static final String ERROR = "Error";
    public static final String HINT = "Hint";

    private final Scanner scanner = new Scanner(System.in);

    private String readLine(String prompt) {   //made private
        if (prompt != null && !prompt.isBlank()) {
            System.out.print(prompt);
        }
        return scanner.nextLine();
    }

    public String readId(String prompt) {
        String id = readLine(prompt);
        if (id != null && !id.trim().isEmpty()) {
            return id;
        } else {
            System.out.println(String.format(FORMAT, ERROR, "Id cannot be blank."));
            return null;
        }
    }

    public int readMenuOption(int min, int max) {
    String raw = readLine("Choose option [" + min + "-" + max + "]: ");
    
    if (raw == null || raw.isBlank()) {
        System.out.println(String.format(FORMAT, ERROR, "No input provided."));
        return 0;
    }

    raw = raw.trim();
    int v;

    try {
        v = Integer.parseInt(raw);
    } catch (NumberFormatException e) {
        System.out.println(String.format(FORMAT, ERROR, "Invalid numeric value."));
        return 0;
    }

    if (v < min || v > max) {
        System.out.println(String.format(FORMAT, ERROR,
                "Invalid option. Must be between " + min + " and " + max + "."));
        return 0;
    }

    return v;
}

    public int readStars() {
        String raw = readLine("Stars [1-5]: ");
        if (raw == null || raw.isBlank()) {
            System.out.println(String.format(FORMAT, ERROR, "No value entered."));
            return 0;
        }

        raw = raw.trim();
        int stars;

        try {
            stars = Integer.parseInt(raw);
        } catch (NumberFormatException e) {
            System.out.println(String.format(FORMAT, ERROR, "Invalid numeric value for stars."));
            return 0;
        }

        if (stars < 1 || stars > 5) {
            System.out.println(String.format(FORMAT, ERROR, "Stars must be between 1 and 5."));
            return 0;
        }

        return stars;
    }

    public String readNoteOptional() {
        String note = readLine("Note (Enter to skip): ");
        if (note != null) {
            note = note.trim();
        }
        return (note != null && !note.isEmpty()) ? note : null;
    }

    public void printLine(String line) {
        System.out.println(line);
    }

    public String formatNumber(double v) {
        double rounded = Math.round(v * 100.0) / 100.0;
        if (rounded == (long) rounded) {
            return String.valueOf((long) rounded);
        }
        return String.valueOf(rounded);
    }

}
