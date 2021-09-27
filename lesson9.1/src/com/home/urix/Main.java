package com.home.urix;


import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int[] mass={10,17,0,-4,9,22,0,-18,63,30,-30, 9};

        double average=IntStream.of(mass).average().orElseThrow(RuntimeException::new);
        System.out.println("average="+average);

        int min=IntStream.of(mass).min().orElseThrow(RuntimeException::new);
        int minPos=IntStream.range(0, mass.length). filter(i->mass[i]==min).findFirst().orElseThrow(RuntimeException::new);
        System.out.println("min="+min+" pos="+minPos);

        long zeroCount=IntStream.of(mass).filter(i->i==0).count();
        System.out.println("Zeros count="+zeroCount);

        long biggerThanZeroCount=IntStream.of(mass).filter(i->i>0).count();
        System.out.println("Bigger then zero="+biggerThanZeroCount);

        final int mult=17;
        int[] multArray=IntStream.of(mass).map(i->i*mult).toArray();
        String printResult=Arrays.stream(multArray).mapToObj(String::valueOf).collect(Collectors.joining(" ")).toString();
        System.out.println(printResult);
        Arrays.stream(multArray).forEach(i->{
            System.out.print(i+" ");
        });
    }
}
