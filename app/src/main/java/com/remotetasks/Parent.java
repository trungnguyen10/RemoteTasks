package com.remotetasks;

import java.util.*;

public class Parent extends User {
    private List<Child> children = new ArrayList<Child>();
    private List<TaskManager> taskList = new ArrayList<TaskManager>();

    public Parent(String name) {
        super(name);
    }

    /**
     * add child to parent's child list
     *
     * @param newChild new child object to be appended to child list
     */
    public void addChild(Child newChild) {
        this.children.add(newChild);
    }

    /**
     * remove child from parent's child list
     *
     * @param child child to be removed from child list
     */
    public void delChild(Child child) {
        for (int x = 0; x < children.size(); x++) {
            if (children.get(x).equals(child)) {
                children.remove(x);
                break;
            }
        }

    }

    /**
     * confirm existence of child in child list
     *
     * @param c child to be located in child list
     */
    public boolean isChild(Child c) {
        boolean isChild = false;
        for (int x = 0; x < children.size(); x++) {
            if (children.get(x) == c) {
                isChild = true;
                break;
            }
        }

        return isChild;
    }

    /**
     * append new task to task list
     *
     * @param newTM new taskmanager object to be appended to task list
     */
    public void addTask(TaskManager newTM) {
        taskList.add(newTM);
    }

    /**
     * get child object from child ID
     *
     * @param ID ID of child to be located
     */
    public Child getChild(String ID) {
        for (int x = 0; x < children.size(); x++) {
            if (children.get(x).getID() == ID) return children.get(x);
        }
        return null;
    }

    /**
     * Get task manager from ID
     *
     * @param ID task manager ID for location
     */
    public TaskManager getTaskMgr(int ID) {
        for (int x = 0; x < taskList.size(); x++) {
            if (taskList.get(x).getTaskMgrID() == ID) return taskList.get(x);
        }
        return null;
    }

    public List<TaskManager> getTaskList() {
        return taskList;
    }

    public List<Child> getChildren() {
        return children;
    }

    /**
     * Update the new state of the Child object to the Parent object
     * @param child the modified Child object
     * @return the updated child in the parent, return null when no child has been updated
     */
    public Child updateChild(Child child) {
        if (children.contains(child)) {
            int index = children.indexOf(child);
            children.set(index, child);
            return children.get(index);
        }
        return null;
    }

    public static Parent demoParent() {
        Parent aParent = new Parent("Daddy");
        Child aChild1 = new Child("Bob");
        for (int i = 0; i < 3; i++) {
            Task task = new Task("Task #" + i, new Goal("Goal #" + i, "Description " + i));
            TaskManager taskManager = new TaskManager.Builder()
                    .addParent(aParent)
                    .addChildren(aChild1)
                    .addTask(task)
                    .build();
            aChild1.addTask(taskManager);
        }
        Child aChild2 = new Child("Tommy");
        for (int i = 4; i < 10; i++) {
            Task task = new Task("Task #" + i, new Goal("Goal #" + i, "Description " + i));
            TaskManager taskManager = new TaskManager.Builder()
                    .addParent(aParent)
                    .addChildren(aChild1)
                    .addTask(task)
                    .build();
            aChild2.addTask(taskManager);
        }

        aParent.addChild(aChild1);
        aParent.addChild(aChild2);

        return aParent;
    }
}
