package com.remotetasks;

import java.util.Objects;

public class User {
    private String userID;
    private String name;

    public User(String name)
    {
        this.name = name;
        String userId = name;
        int idNumber = (int)((Math.random() * (99999 - 10000)) + 10000);
        userId += String.valueOf(idNumber);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userID == user.userID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID);
    }

    public String getUserID()
    {
        return this.userID;
    }
}
