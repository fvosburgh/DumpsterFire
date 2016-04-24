package com.example.fvosb.dumpsterfire.models;

import java.util.ArrayList;

/**
 * Created by Forester on 4/24/2016.
 */
public class OrderManager {
    private static Order currentOrder;

    public OrderManager(Order order) {
        currentOrder = order;
    }

    public static Order getCurrentOrder() {
        return currentOrder;
    }

    public static void setCurrentOrder(Order order) {
        currentOrder = order;
    }
}
