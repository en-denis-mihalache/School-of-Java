package service;

import model.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import repository.TaskRepository;

public class TaskService {
    private final TaskRepository repo = new TaskRepository();
    private int nextId = 1;

    public Task addTask(String title, LocalDate dueDate, Category category, int priority) {
        Task task = new Task();
        task.setId(nextId++);
        task.setTitle(title);
        task.setDueDate(dueDate);
        task.setCategory(category);
        task.setPriority(priority);
        task.setStatus(Status.PENDING);
        repo.add(task);
        return task;
    }

    public List<Task> listAll() {
        return repo.findAll();
    }

    public List<Task> listPending() {
        return repo.findAll().stream()
                .filter(task -> task.getStatus() == Status.PENDING)
                .toList();
    }

    public boolean markDone(int id) {
        return repo.findAll().stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .map(t -> { t.setStatus(Status.DONE); return true; })
                .orElse(false);
    }

    public List<Task> searchByTitle(String keyword) {
        return repo.findAll().stream()
                .filter(t -> t.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }

    public void summary(){
        long totalTasks = repo.findAll().size();
        long doneTasks = repo.findAll().stream()
                .filter(t -> t.getStatus() == Status.DONE)
                .count();
        long pendingTasks = repo.findAll().stream()
                .filter(t -> t.getStatus() == Status.PENDING)
                .count();

        System.out.println("=== Summary ===");
        System.out.println("Total tasks: " + totalTasks);
        System.out.println("Done tasks: " + doneTasks);
        System.out.println("Pending tasks: " + pendingTasks);
        System.out.println();

        System.out.println("\nTasks by category:");
        repo.findAll().stream()
                .collect(Collectors.groupingBy(Task::getCategory))
                .forEach((cat, list) -> {
                    System.out.println(cat + ": " + list.size());
                    list.forEach(task -> System.out.println("  - " + task.getTitle()));
                });


        System.out.println("\nTop priority pending:");
        repo.findAll().stream()
                .filter(t -> t.getStatus() == Status.PENDING)
                .max(Comparator.comparing(Task::getPriority).reversed()
                        .thenComparing(Task::getDueDate)).ifPresent(System.out::println);

    }


}