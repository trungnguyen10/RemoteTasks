package com.remotetasks;

public class Task {
    private String taskName;
    private Goal taskGoal;

    public Task(String taskName, Goal taskGoal) {
        this.taskName = taskName;
        this.taskGoal = taskGoal;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Goal getTaskGoal() {
        return taskGoal;
    }

    public void setTaskGoal(Goal taskGoal) {
        this.taskGoal = taskGoal;
    }
}
