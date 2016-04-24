package com.example.fvosb.dumpsterfire.models;

import java.util.ArrayList;

/**
 * Created by Forester on 4/24/2016.
 */
public class Order {

    private String cardUsed;
    private ArrayList<Reservation> reservations;
    private int id;

    public Order(String cardUsed, ArrayList<Reservation> reservations) {
        this.cardUsed = cardUsed;
        this.reservations = reservations;
    }

    public String getCardUsed() {
        return cardUsed;
    }

    public void setCardUsed(String card) {
        cardUsed = card;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setId(int id) {
        this.id = id;
    }
}
