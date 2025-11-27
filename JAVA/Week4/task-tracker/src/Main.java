import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.*;

import model.*;
import service.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new TaskService();

        taskService.addTask("Learn Streams", LocalDate.now().plusDays(2), Category.WORK, 4);
        taskService.addTask("Buy groceries", LocalDate.now().plusDays(1), Category.PERSONAL, 2);


        while (true) {
            System.out.println("""
                    === Task Tracker ===
                    1) Add task
                    2) List all
                    3) List pending
                    4) Mark done
                    5) Search by title
                    6) Summary
                    7) Quit
                    """);

            System.out.print("Choose option: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Please enter a valid number!\n");
                continue;
            }

            MenuOption.fromCode(choice).ifPresentOrElse(
                    option -> {
                        switch (option) {
                            case ADD -> handleAddTask(taskService, scanner);
                            case LIST_ALL -> handleListAll(taskService);
                            case LIST_PENDING -> handleListPending(taskService);
                            case MARK_DONE -> handleMarkDone(taskService, scanner);
                            case SEARCH -> handleSearchByTitle(taskService, scanner);
                            case SUMMARY -> handleSummary(taskService);
                            case QUIT -> {
                                System.out.println("Goodbye!");
                                System.exit(0);
                            }
                        }
                    },
                    () -> System.out.println("⚠️ Invalid menu option!\n")
            );

        }


    }

    private static void handleAddTask(TaskService taskService, Scanner scanner) {
        System.out.print("Insert task title: ");
        String title = scanner.nextLine();

        LocalDate dueDate = null;
        while (dueDate == null) {
            System.out.print("Insert due date (YYYY-MM-DD): ");
            try {
                LocalDate input = LocalDate.parse(scanner.nextLine());
                LocalDate today = LocalDate.now();

                if (input.isBefore(today)) {
                    System.out.println("⚠️ Date cannot be in the past. Try again!");
                } else if (input.isAfter(today.plusYears(1))) {
                    System.out.println("💡 Let's be productive — pick something within the next year at least! \uD83D\uDE04");
                } else {
                    dueDate = input;
                }
            } catch (DateTimeParseException e) {
                System.out.println("⚠️ Please enter a valid date (format: YYYY-MM-DD).");
            }
        }


        Category category = null;
        while (category == null) {
            System.out.print("Insert category (WORK or PERSONAL): ");
            try {
                category = Category.valueOf(scanner.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("⚠️ Invalid category! Please choose WORK or PERSONAL.");
            }
        }

        int priority = 0;
        while (priority == 0) {
            System.out.print("Insert priority (1–5): ");
            try {
                priority = Integer.parseInt(scanner.nextLine());
                if (priority < 1 || priority > 5) {
                    System.out.println("⚠️ Priority must be between 1 and 5.");
                    priority = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Please enter a valid number for priority.");
            }

        }


        taskService.addTask(title, dueDate, category, priority);
        System.out.println("✅ Task added successfully!");
    }

    private static void handleListAll(TaskService taskService) {
        taskService.listAll().forEach(System.out::println);
    }

    private static void handleListPending(TaskService taskService) {
        taskService.listPending().forEach(System.out::println);
    }

    private static void handleMarkDone(TaskService taskService, Scanner scanner) {
        System.out.print("Insert task ID to mark as done: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean success = taskService.markDone(id);
        if (success) {
            System.out.println("✅ Task marked as done!");
            System.out.println();
        } else {
            System.out.println("❌ Task not found!");
            System.out.println();
        }
    }

    private static void handleSearchByTitle(TaskService taskService, Scanner scanner) {
        System.out.print("Insert keyword to search in titles: ");
        String keyword = scanner.nextLine();
        List<Task> results = taskService.searchByTitle(keyword);
        if (results.isEmpty()) {
            System.out.println("No tasks found with the given keyword.");
            System.out.println();
        } else {
            results.forEach(System.out::println);
            System.out.println();
        }
    }

    private static void handleSummary(TaskService taskService) {
        taskService.summary();
    }

}