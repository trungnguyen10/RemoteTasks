package com.remotetasks;

public class IDGenerator {
    private static int userID = 0;
    private static int taskID = 0;

    public static final int generateUserID() {
        return userID++;
    }

    public static final int generateTaskID() {
        return taskID++;
    }
}
