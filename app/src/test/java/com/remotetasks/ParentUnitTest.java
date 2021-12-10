package com.remotetasks;

import org.junit.Test;

import static org.junit.Assert.*;

import com.remotetasks.Model.Child;
import com.remotetasks.Model.Goal;
import com.remotetasks.Model.Parent;
import com.remotetasks.Model.Task;
import com.remotetasks.Model.TaskManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ParentUnitTest {

    @Test
    public void getChild() {
        Parent parent = new Parent ("Tom");
        Child child = new Child ("John");
        String childID = child.getID();
        parent.addChild(child);
        assertEquals(child, parent.getChild(childID));
    }
    @Test
    public void getChildren(){

        Parent parent = new Parent("Tom");
        Child child1 = new Child("John");
        Child child2 = new Child("Bob");
        List<Child> expectedChildren = new ArrayList<>();
        expectedChildren.add(child1);
        expectedChildren.add(child2);

        parent.addChild(child1);
        parent.addChild(child2);

        assertEquals(expectedChildren, parent.getChildren());
    }

    @Test
    public void updateChild(){
        Parent parent = new Parent ("Tom");
        Child child = new Child("John");

        parent.addChild(child);

        Task task = new Task("Test Task", new Goal("Task Goal", "Test Description"));
        TaskManager taskManager = new TaskManager.Builder().addParent(parent).addChildren(child).addTask(task).addStartTime(LocalDate.now()).addEndTime(null).build();
        child.addTask(taskManager);

        parent.updateChild(child);

        assertEquals(child, parent.getChild(child.getID()));
    }




}