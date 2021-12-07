package com.remotetasks;

import java.util.Objects;

public class User {
    private int userID;
    private String name;

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

    public int getUserID()
    {
        return this.userID;
    }
}
