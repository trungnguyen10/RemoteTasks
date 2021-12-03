package com.remotetasks;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskManager {
    private Parent mParent;
    private ArrayList<Child> mListOfChild;
    private Task mTask;
    private IReward mReward;
    private LocalDateTime mStartTime;
    private LocalDateTime mEndTime;
    private Duration mExtensionTime;


}
