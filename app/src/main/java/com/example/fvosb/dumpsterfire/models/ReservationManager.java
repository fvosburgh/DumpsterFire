package com.example.fvosb.dumpsterfire.models;


import java.util.HashMap;

public class ReservationManager {

    private static HashMap<String, Reservation> reservations;
    private static Reservation currentReservation;

    public ReservationManager() {
        reservations = null;
    }

    public static void addResrvation(Reservation r) {
        reservations.put(UserManager.getCurrrentUser(), r);
    }

    public static void setCurrentReservation(Reservation r) {
        currentReservation = r;
    }
}
