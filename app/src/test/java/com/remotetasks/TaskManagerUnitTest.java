package com.remotetasks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.time.LocalDate;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TaskManagerUnitTest {

    @Test
    public void addTask() {
        Task task = new Task("Test Task", new Goal("Task Goal", "Test Description"));
        TaskManager taskManager = new TaskManager.Builder().addTask(task).build();

        assertEquals(task, taskManager.getTask());

    }

    @Test
    public void addParent() {
        Parent parent = new Parent("Test Parent");
        TaskManager taskManager = new TaskManager.Builder().addParent(parent).build();

        assertEquals(parent, taskManager.getParent());

    }

    @Test
    public void addChild() {
        Child child = new Child("Test Child");
        TaskManager taskManager = new TaskManager.Builder().addChildren(child).build();

        assertEquals(child, taskManager.getListOfChild().get(0));

    }

    @Test
    public void addEndTime(){
        LocalDate endTime = LocalDate.now();
        TaskManager taskManager = new TaskManager.Builder().addEndTime(endTime).build();

        assertEquals(endTime, taskManager.getEndTime());
    }

    @Test
    public void addStartTime(){
        LocalDate startTime = LocalDate.now();
        TaskManager taskManager = new TaskManager.Builder().addStartTime(startTime).build();

        assertEquals(startTime, taskManager.getStartTime());
    }

    @Test
    public void addReward(){
        IReward reward = new ScreenTimeReward(3);
        TaskManager taskManager = new TaskManager.Builder().addReward(reward).build();

        assertEquals(reward, taskManager.getReward());
    }




}