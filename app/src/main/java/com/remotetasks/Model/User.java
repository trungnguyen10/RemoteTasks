package com.remotetasks.Model;

import java.util.Objects;

public class User {
    private String userID;
    private String name;

    public User(String name)
    {
        this.name = name;
        this.userID = name.toLowerCase().replace(" ","") + String.valueOf(IDGenerator.generateUserID());
    }
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userID == user.userID;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(userID);
    }

    public String getUserID()
    {
        return this.userID;
    }

    public String getName() { return this.name;}
}
