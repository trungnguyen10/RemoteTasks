package com.remotetasks;
import java.util.*;
import java.time.Duration;
public class Child extends User
{
    private ScreenTime ST;

    private List<Parent> parents = new ArrayList<Parent>();
    private List<TaskManager> taskList = new ArrayList<TaskManager>();

    public Child(String name)
    {
        super(name);
        this.ST = new ScreenTime(0);
    }

    /**
     * Getter method for child object ID
     */

    public String getID()
    {
        return this.getUserID();
    }

    /**
     * Verifies relationship between child and parent
     *
     * @param p object to be located
     */
    public boolean isParent(Parent p)
    {
        boolean isParent = false;
        for(int x = 0 ; x < parents.size() ; x++)
        {
            if(parents.get(x).equals(p)){isParent = true;break;}
        }

        return isParent;
    }
    /**
     * Increments screen time
     *
     * @param increment object to be added to Child's screentime
     */
    public void increaseScreenTime(ScreenTime increment)
    {
        this.ST.increaseTime(increment);
    }
    /**
     * Decrements screen time
     *
     * @param decrement object to be subtracted from Child's screentime
     */
    public void decreaseScreenTime(ScreenTime decrement)
    {
        this.ST.decreaseTime(decrement);
    }
    /**
     * Set screen time given hours
     *
     * @param hour the number hours to initialize screentime
     */
    public void setScreenTime(long hour)
    {
        this.ST.setHour(hour);
    }
    /**
     * add task object to tasklist
     *
     * @param newTask task object to append to tasklist
     */
    public void addTask(TaskManager newTask)
    {
        this.taskList.add(newTask);
    }
    /**
     * returns taskmanager object given ID
     *
     * @param ID id of taskmanager to locate
     */
    public TaskManager getTaskMgr(int ID)
    {
        for(int x = 0 ; x < taskList.size() ; x++)
        {
            if(taskList.get(x).getTaskMgrID() == ID) return taskList.get(x);
        }
        return null;
    }

    public int countTask(){
        return this.taskList.size();
    }
    public List<TaskManager> getTaskList() {
        return taskList;
    }
}
