package com.remotetasks;

public class ScreenTimeReward implements IReward{
    private ScreenTime time;

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
