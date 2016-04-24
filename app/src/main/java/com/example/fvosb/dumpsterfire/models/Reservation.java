package com.example.fvosb.dumpsterfire.models;


import java.util.HashMap;

public class Reservation {

    // use hash map for backing data structure
    private HashMap<String, String> reservationData = new HashMap<>();

    // null constructor
    public Reservation() {
    }

    public void add(String key, String value) {
        reservationData.put(key, value);
    }

    public String get(String key) {
        return reservationData.get(key);
    }


}
