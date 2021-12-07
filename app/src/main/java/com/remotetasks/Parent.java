package com.remotetasks;

import java.util.*;

public class Parent extends User {
    private List<Child> children = new ArrayList<Child>();
    private List<TaskManager> taskList = new ArrayList<TaskManager>();

    public Parent(String name)
    {
        super(name);
    }
    /**
     * add child to parent's child list
     *
     * @param newChild new child object to be appended to child list
     */
    public void addChild(Child newChild)
    {
        this.children.add(newChild);
    }
    /**
     * remove child from parent's child list
     *
     * @param child child to be removed from child list
     */
    public void delChild(Child child)
    {
        for(int x = 0 ; x < children.size() ; x++)
        {
            if(children.get(x).equals(child)){children.remove(x);break;}
        }

    }
    /**
     * confirm existence of child in child list
     *
     * @param c child to be located in child list
     */
    public boolean isChild(Child c)
    {
        boolean isChild = false;
        for(int x = 0 ; x < children.size() ; x++)
        {
            if(children.get(x) == c){isChild = true;}
        }

        return isChild;
    }
    /**
     * append new task to task list
     *
     * @param newTM new taskmanager object to be appended to task list
     */
    public void addTask(TaskManager newTM)
    {
        taskList.add(newTM);
    }
    /**
     * get child object from child ID
     *
     * @param ID ID of child to be located
     */
    public Child getChild(String ID)
    {
        for(int x = 0 ; x < children.size() ; x++)
        {
            if(children.get(x).getID() == ID)
            {
                return children.get(x);
            }
        }
        return null;

    }
    /**
     * Get task manager from ID
     *
     * @param ID task manager ID for location
     */
    public TaskManager getTaskMgr(int ID)
    {
        for(int x = 0 ; x < taskList.size() ; x++)
        {
            if(taskList.get(x).getTaskMgrID() == ID) return taskList.get(x);
        }
        return null;
    }



}
