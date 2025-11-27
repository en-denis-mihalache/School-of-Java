package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {

    private int id;
    private String title;
    private LocalDate dueDate;
    private Category category;
    private Status status;
    private int priority;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    };

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public String toString() {
        return String.format("%d - Task: %s, in category: %s, due date - %s, priority=%d, status=%s.\n",
                 id, title, category, dueDate, priority, status);
    }
}