package com.example.fvosb.dumpsterfire.models;

public class UserManager {

    private static String currUser;

    public UserManager(String user) {
        currUser = user;
    }

    public static void setCurrentUser(String user) {
        currUser = user;
    }

    public static String getCurrrentUser() {
        return currUser;
    }
}
