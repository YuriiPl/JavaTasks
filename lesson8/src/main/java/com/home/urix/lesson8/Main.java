package com.home.urix.lesson8;

import com.home.urix.lesson8.Task1.Calculator;
import com.home.urix.lesson8.Task2.MyArrayList;

import java.util.ArrayList;
import java.util.Random;


public class Main {
    public static void main(String ... args){

        //Task1
        ArrayList<Integer> array = new ArrayList<Integer>();
        new Random().ints(25, -10,10).forEach(array::add);
        System.out.println(array);
        System.out.println(Calculator.calc1(array));
        System.out.println(Calculator.calc2(array));
        System.out.println(Calculator.calc3(array));

        //Task2
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        new Random().ints(25, -10,10).peek(x-> System.out.print(x+" ")).forEach(myArrayList::add);
        System.out.println();
        System.out.println(myArrayList);
        for (Integer i : myArrayList){
            System.out.print(i);
            System.out.print(' ');
        }

    }
}
