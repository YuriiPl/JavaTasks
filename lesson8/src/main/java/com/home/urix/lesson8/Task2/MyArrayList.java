package com.home.urix.lesson8.Task2;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements MyArrayListInterface<E> {
    private final static int INITIAL_SIZE=10;
    private final float CAPACITY_FACTOR =1.6F;
    private final float FILL_FACTOR = 0.75F;
    private Object[] array;
    private int size=0;

    public MyArrayList(){
        array = new Object[INITIAL_SIZE];
    }

    @Override
    public boolean add(E e) {
        if(array.length*FILL_FACTOR<size){
            array=Arrays.copyOf(array, (int) (array.length*CAPACITY_FACTOR));
        }
        array[size++]=e;
        return false;
    }

    @Override
    public E get(int index) {
        if(index>=size()) throw new ArrayIndexOutOfBoundsException();
        return (E)array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int current=0;
            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public E next() {
                return (E)array[current++];
            }
        };
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array,size));
    }
}
