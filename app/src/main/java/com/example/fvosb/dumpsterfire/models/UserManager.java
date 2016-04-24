package com.example.fvosb.dumpsterfire.models;

public class UserManager {

    private static User currUser;

    public UserManager(User user) {
        currUser = user;
    }

    public static void setCurrentUser(User user) {
        currUser = user;
    }

    public static User getCurrrentUser() {
        return currUser;
    }
}
