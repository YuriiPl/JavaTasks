package com.home.urix.lesson6.immutable;

public final class Car {
    private final int year;
    private final String color;
    private final Engine engine;

    public Car(int year, String color, Engine engine) {
        this.year = year;
        this.color = color;
        this.engine = new Engine(engine.getHorsePower(),engine.getManufacturer());
    }

    public Engine getEngine() {
        return new Engine(engine.getHorsePower(),engine.getManufacturer());
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public Car setYear(int year) {
        return new Car(year,getColor(),getEngine());
    }

    public Car setColor(String color) {
        return new Car(getYear(),color,getEngine());
    }

    public Car setEngine(Engine engine) {
        return new Car(getYear(),getColor(),engine);
    }

}
