package com.home.urix.JavaGame;

import java.util.Arrays;
import java.util.Random;


class StatItem{
    public int value;
    public StatItem next;
    StatItem(int val){
        value=val;
    }
}

class StatList{
    private StatItem begin;
    private StatItem current;
    int length=0;
    void add(int value){
        length++;
        if(null==begin){
            begin=new StatItem(value);
            current=begin;
            return;
        }
        current.next=new StatItem(value);
        current=current.next;
    }
    StatItem begin(){
        return begin;
    }
}

public class Model {
    private int leftLimit=0;
    private int rightLimit=100;
    private final int value;

    StatList statList;

    public Model() {
        this.value = new Random().nextInt(100);
        statList = new StatList();
    }

    public int getLeftLimit() {
        return leftLimit;
    }

    public void setLeftLimit(int leftLimit) {
        this.leftLimit = leftLimit;
    }

    public int getRightLimit() {
        return rightLimit;
    }

    public void setRightLimit(int rightLimit) {
        this.rightLimit = rightLimit;
    }

    public boolean isNotInRange(int value){
        return value<getLeftLimit() || value>getRightLimit();
    }

    public boolean isGuessed (int value){
        return this.value==value;
    }

    public boolean isBigger(int value) {
        return this.value<value;
    }

    public boolean isSmaller(int value) {
        return this.value>value;
    }

    public void changeLimits(int value){
        if(isBigger(value)){
            setRightLimit(value-1);
        } else {
            setLeftLimit(value+1);
        }
    }

    public void saveStat(int val){
        statList.add(val);
    }

    int[] getStats(){
        int[] values=new int[statList.length];
        StatItem item=statList.begin();
        int i=0;
        while(null!=item){
            values[i]=item.value;
            item=item.next;
            i++;
        }
        return values;
    }
}
