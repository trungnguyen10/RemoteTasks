package com.remotetasks.Model;

public class ScreenTimeReward implements IReward{
    private ScreenTime time;

    public ScreenTimeReward(int hoursOfTime){
        this.time = new ScreenTime(hoursOfTime);
    }

    /**
     * reward screen time for task completion
     *
     * @param u Screentime granted to child u
     */
    @Override
    public void grantReward(Child u)
    {
        u.increaseScreenTime(time);
    }

}
