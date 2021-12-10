package com.remotetasks.Model;

public class Goal {
    private String goalName;
    private String goalDescription;

    public Goal(String goalName, String goalDescription) {
        this.goalName = goalName;
        this.goalDescription = goalDescription;
    }

    public String getGoalName() {
        return goalName;
    }

    public String getGoalDescription() {
        return goalDescription;
    }
}
