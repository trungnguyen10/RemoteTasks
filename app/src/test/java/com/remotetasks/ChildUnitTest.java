package com.remotetasks;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ChildUnitTest {

    @Test
    public void addTask() {
        Child child = new Child ("Test Child");
        Task task = new Task("Test Task", new Goal("Task Goal", "Test Description"));
        TaskManager taskManager = new TaskManager.Builder().addTaskMgrID().addParent(null).addChildren(child).addTask(task).addStartTime(LocalDate.now()).addEndTime(null).build();
        child.addTask(taskManager);

        assertEquals(taskManager, child.getTaskMgr(0));
    }

    @Test
    public void getID() {
        Child child = new Child("Test Child");
        String expectedID = "Test Child0";

        assertEquals(expectedID, child.getID());
    }

}