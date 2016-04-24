package com.example.fvosb.dumpsterfire.models;


import com.example.fvosb.dumpsterfire.activities.PopulatedScheduleActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class ReservationManager {

    private static HashMap<User, ArrayList<Reservation>> reservations = new HashMap<>();
    private static Reservation currentReservation = new Reservation();

    public ReservationManager() {
    }

    public static void addResrvation(Reservation r) {
        ArrayList<Reservation> list = getAllReservations();
        list.add(r);
        reservations.put(UserManager.getCurrrentUser(), list);
    }

    public static void setCurrentReservation(Reservation r) {
        currentReservation = r;
    }

    public static Reservation getCurrentReservation() {
        return currentReservation;
    }

    public static ArrayList<Reservation> getAllReservations() {
        if(reservations.get(UserManager.getCurrrentUser()) == null) {
            return new ArrayList<Reservation>();
        } else {
            return reservations.get(UserManager.getCurrrentUser());
        }
    }
}
