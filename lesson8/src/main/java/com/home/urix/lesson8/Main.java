package com.home.urix.lesson8;

import com.home.urix.lesson8.Task1.Calculator;

import java.util.ArrayList;
import java.util.Random;


public class Main {
    public static void main(String ... args){

        //Task1
        ArrayList<Integer> test = new ArrayList<>();
        new Random().ints(25, -10,10).forEach(test::add);
        System.out.println(test);
        System.out.println(Calculator.calc(test));

        
    }
}
