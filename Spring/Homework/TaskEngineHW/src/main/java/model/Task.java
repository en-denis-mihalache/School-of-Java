package model;

public class Task {
    private String taskName;
    private String skill;

    public Task(String taskName, String skill) {
        this.taskName = taskName;
        this.skill = skill;
    }

    public String getSkill() {
        return  skill;
    }

    public String getTaskName() {
        return taskName;
    }
}