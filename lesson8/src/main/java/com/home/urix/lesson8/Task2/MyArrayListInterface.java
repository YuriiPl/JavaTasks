package com.home.urix.lesson8.Task2;


public interface MyArrayListInterface<E> extends Iterable<E> {
    boolean add(E e);
    E get(int index);
    int size();
}
