package repository;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public Task add(Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return task;
    }

    public List<Task> findAll() {
        return tasks;
    }
}