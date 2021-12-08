package com.remotetasks;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TaskManager represents a task and its associated parents, children, starting and ending time, the reward on completion
 */
public class TaskManager {

    private int mTaskMgrID;
    private Parent mParent;
    private List<Child> mListOfChild;
    private Task mTask;
    private IReward mReward;
    private LocalDateTime mStartTime;
    private LocalDateTime mEndTime;
    private int mExtensionHours;
    private Status mStatus = Status.IN_PROCESS;

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

    public int getTaskMgrID()
    {
        return this.mTaskMgrID;
    }

    public void grantReward(Child c) {
        mReward.grantReward(c);
    }

    public Parent getParent() {
        return mParent;
    }

    public List<Child> getListOfChild() {
        return mListOfChild;
    }

    public Task getTask() {
        return mTask;
    }

    public IReward getReward() {
        return mReward;
    }

    public LocalDateTime getStartTime() {
        return mStartTime;
    }

    public LocalDateTime getEndTime() {
        return mEndTime;
    }

    public int getExtensionHours() {
        return mExtensionHours;
    }

    public Status getStatus() {
        LocalDateTime rightNow = LocalDateTime.now();
        if (mStatus == Status.IN_PROCESS && rightNow.isAfter(mEndTime)){
            mStatus = Status.FAILED;
        }
        return mStatus;
    }

    private void setStatus(Status status) {
        mStatus = status;
    }

    public void setStartTime(LocalDateTime startTime) {
        mStartTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        mEndTime = endTime;
    }

    public void requestExtension(int hoursToExtend) {
        LocalDateTime rightNow = LocalDateTime.now();
        LocalDateTime extendedTime = mEndTime.plusHours(hoursToExtend);
        if (rightNow.isBefore(extendedTime)) {
            mExtensionHours = hoursToExtend;
            mStatus = Status.PENDING_FOR_EXTENSION;
        }
    }

    public void approveExtension() {
        mEndTime = mEndTime.plusHours(mExtensionHours);
        mExtensionHours = 0;
        mStatus = Status.IN_PROCESS;
    }

    public void submitTask(){
        LocalDateTime rightNow = LocalDateTime.now();
        if(rightNow.isBefore(mEndTime)) {
            mStatus = Status.PENDING_FOR_COMPLETION;
        }
    }

    public void approveTask() {
        mStatus = Status.COMPLETED;
    }

    public void addChildren(Child... children) {
        if (mListOfChild == null) {
            mListOfChild = new ArrayList<>();
        }
        for (Child c : children) {
            mListOfChild.add(c);
        }
    }

    private TaskManager(Builder builder) {
        this.mTaskMgrID = builder.mTaskMgrID;
        this.mParent = builder.mParent;
        this.mListOfChild = builder.mListOfChild;
        this.mTask = builder.mTask;
        this.mReward = builder.mReward;
        this.mStartTime = builder.mStartTime;
        this.mEndTime = builder.mEndTime;
        this.mExtensionHours = builder.mExtensionHours;
    }

    public static class Builder {
        private int mTaskMgrID;
        private Parent mParent;
        private ArrayList<Child> mListOfChild;
        private Task mTask;
        private IReward mReward;
        private LocalDateTime mStartTime;
        private LocalDateTime mEndTime;
        private int mExtensionHours = 0;

        public Builder addTaskMgrID() {
            this.mTaskMgrID = IDGenerator.generateTaskID();
            return this;
        }

        public Builder addParent(Parent p) {
            this.mParent = p;
            return this;
        }

        public Builder addChildren(Child... children) {
            mListOfChild = new ArrayList<>();
            for (Child child : children) {
                this.mListOfChild.add(child);
            }
            return this;
        }

        public Builder addTask(Task t) {
            this.mTask = t;
            return this;
        }

        public Builder addReward(IReward reward) {
            this.mReward = reward;
            return this;
        }

        public Builder addStartTime(LocalDateTime startTime) {
            this.mStartTime = startTime;
            return this;
        }

        public Builder addEndTime(LocalDateTime endTime) {
            this.mEndTime = endTime;
            return this;
        }

        public TaskManager build() {
            return new TaskManager(this);
        }
    }
}
