package com.home.urix.lesson8.Task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Calculator {
    public static Map<Integer, Integer> calc1(ArrayList<Integer> list){
        Map<Integer, Integer> map = new HashMap<>();
        list.forEach(x->{
            map.put(x,(map.getOrDefault(x, 0))+1);
        });
        return map;
    }

    public static Map<Integer, Integer> calc2(ArrayList<Integer> list){
        return list.stream().collect(Collectors.toMap(k -> k, k->1, Integer::sum));
    }

    public static Map<Integer, Integer> calc3(ArrayList<Integer> list){
        return list.stream().collect(Collectors.groupingBy(k->k,Collectors.reducing(0,k->1,Integer::sum)));
    }
}
