package com.remotetasks.Model;

import androidx.annotation.NonNull;

import java.time.Duration;

/**
 * Represent the phone's screen time of an user in hours
 *
 * @author trung
 */
public class ScreenTime {
    private Duration hour;

    /**
     * Create a screen time object with the specified number of hours
     *
     * @param hour the number of hours of the screen time
     */
    public ScreenTime(long hour) {
        this.hour = Duration.ofHours(hour);
    }

    /**
     * Return the number of hours of the screen hour
     *
     * @return A long integer representing the number of the screen time
     */
    public long getHour() {
        return hour.toHours();
    }

    /**
     * Set the number of hours of the screen time
     *
     * @param hour the number of hours of the screen time
     */
    public void setHour(long hour) {
        this.hour = Duration.ofHours(hour);
    }

    /**
     * Increase the hours of the screen time by another screen time
     *
     * @param t the other screen time
     */
    public void increaseTime(@NonNull ScreenTime t) {
        hour = hour.plus(Duration.ofHours(t.getHour()));
    }

    /**
     * Decrease the hours of the screen time by another screen time
     * If the other screen time has greater number of hours, the hours of the screen time will be 0
     *
     * @param t
     */
    public void decreaseTime(@NonNull ScreenTime t) {
        long decreaseHours = t.getHour();
        if (this.getHour() >= t.getHour()) {
            this.setHour(this.getHour() - t.getHour());
        } else {
            this.setHour(0);
        }
    }
}
