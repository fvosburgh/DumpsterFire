package com.example.fvosb.dumpsterfire.models;

import java.util.ArrayList;

public class User {

    private ArrayList<String> cards = new ArrayList<>();
    private String username;
    private Order order;
    private boolean isStudent;

    public User(String username) {
        this.username = username;
    }

    public void addCard(String cardNumber) {
        cards.add(cardNumber);
    }

    public ArrayList<String> getCards() {
        return cards;
    }

    public String getUsername() {
        return username;
    }

    public void setOrder(Order o) {
        order = o;
    }

    public Order getOrder() {
        return order;
    }

    public boolean getIsStudent() { return isStudent; }

    public void setIsStudent(boolean b) { isStudent = b; }
}
