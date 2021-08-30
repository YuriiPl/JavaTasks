package com.home.urix;

import java.util.ArrayList;
import java.util.Random;

import static com.home.urix.GuessResult.*;

public class Model {
    private int value;
    private boolean gameFinished;
    private int leftLimit, rightLimit;
    ArrayList<Integer> attempts  = new ArrayList<>();

    public int initGame() {
        gameFinished=false;
        value=(int)(new Random().nextInt(99)+1);
        leftLimit=0;
        rightLimit=100;
        return value;
    }

    public boolean gameInProcess() {
        return !gameFinished;
    }

    public int getLeftLimit() {
        return leftLimit;
    }

    public int getRightLimit() {
        return rightLimit;
    }

    public boolean notInRange(int value){
        return value>=getRightLimit() || value<=getLeftLimit();
    }

    public GuessResult processUserInput(int userValue) {
        attempts.add(userValue);
        changeRange(userValue);
        if(value<userValue)return MANY;
        if(value>userValue)return FEW;
        gameFinished=true;
        return EQUALS;
    }

    private void changeRange(int userValue) {
        if(value<userValue)rightLimit=userValue;
        if(value>userValue)leftLimit=userValue;
    }

    public ArrayList<Integer> getAttempts() {
        //return (ArrayList<Integer>)attempts.clone();
        return new ArrayList<>(attempts);
    }
}
