package com.example.fvosb.dumpsterfire.models;

/**
 * Created by Kevin on 4/24/2016.
 */
public class TrainManager {
    private static Train currTrain;

    public TrainManager(Train train) { currTrain = train; }

    public static void setCurrTrain(Train train) { currTrain = train; }

    public static Train getCurrTrain() {
        if (currTrain == null) {
            currTrain = new Train("000");
        }

        return currTrain;
    }
}
