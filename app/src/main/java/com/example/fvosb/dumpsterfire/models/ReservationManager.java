package com.example.fvosb.dumpsterfire.models;


import java.util.HashMap;

public class ReservationManager {

    private static HashMap<String, Reservation> reservations = new HashMap<>();
    private static Reservation currentReservation = new Reservation();

    public ReservationManager() {
    }

    public static void addResrvation(Reservation r) {
        reservations.put(UserManager.getCurrrentUser(), r);
    }

    public static void setCurrentReservation(Reservation r) {
        currentReservation = r;
    }

    public static Reservation getCurrentReservation() {
        return currentReservation;
    }
}
