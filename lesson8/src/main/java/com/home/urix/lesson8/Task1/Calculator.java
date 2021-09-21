package com.home.urix.lesson8.Task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Calculator {
    public static Map<Integer, Integer> calc(ArrayList<Integer> list){
        Map<Integer, Integer> map = new HashMap<>();
        list.stream().forEach(x->{
            map.put(x,(map.getOrDefault(x, 0))+1);
        });
        return map;
    }
}
