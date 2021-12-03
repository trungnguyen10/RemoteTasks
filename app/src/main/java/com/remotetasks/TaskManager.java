package com.remotetasks;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class TaskManager {

    private int mTaskMgrID;
    private Parent mParent;
    private ArrayList<Child> mListOfChild;
    private Task mTask;
    private IReward mReward;
    private LocalDateTime mStartTime;
    private LocalDateTime mEndTime;
    private Duration mExtensionTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskManager)) return false;
        TaskManager that = (TaskManager) o;
        return mTaskMgrID == that.mTaskMgrID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mTaskMgrID);
    }

    public Status getStatus() {
        //dummy codes, will be implemented soon!
        Status currentStatus = Status.COMPLETED;
        return currentStatus;
    }

    private TaskManager(TaskManagerBuilder builder) {
        this.mTaskMgrID = builder.mTaskMgrID;
        this.mParent = builder.mParent;
        this.mListOfChild = builder.mListOfChild;
        this.mTask = builder.mTask;
        this.mReward = builder.mReward;
        this.mStartTime = builder.mStartTime;
        this.mEndTime = builder.mEndTime;
        this.mExtensionTime = builder.mExtensionTime;
    }

    public static class TaskManagerBuilder {
        private int mTaskMgrID;
        private Parent mParent;
        private ArrayList<Child> mListOfChild;
        private Task mTask;
        private IReward mReward;
        private LocalDateTime mStartTime;
        private LocalDateTime mEndTime;
        private Duration mExtensionTime = Duration.ofHours(0);

        public TaskManagerBuilder addTaskMgrID(int id) {
            this.mTaskMgrID = id;
            return this;
        }

        public TaskManagerBuilder addParent(Parent p) {
            this.mParent = p;
            return this;
        }

        public TaskManagerBuilder addChildren(Child... children) {
            for (Child child : children) {
                this.mListOfChild.add(child);
            }
            return this;
        }

        public TaskManagerBuilder addTask(Task t) {
            this.mTask = t;
            return this;
        }

        public TaskManagerBuilder addReward(IReward reward) {
            this.mReward = reward;
            return this;
        }

        public TaskManagerBuilder addStartTime(LocalDateTime startTime) {
            this.mStartTime = startTime;
            return this;
        }

        public TaskManagerBuilder addEndTime(LocalDateTime endTime) {
            this.mEndTime = endTime;
            return this;
        }

        public TaskManager build() {
            return new TaskManager(this);
        }
    }
}
