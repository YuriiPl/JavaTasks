package com.home.urix.lesson6.immutable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class CarTest  {
    private Engine testEngine;
    private Car testCar;

    @Before
    public void setUp() {
        testEngine = new Engine(100, "Manufacturer");
        testCar = new Car(2020, "white", testEngine);
    }

    @Test
    public void getEngineTest() {
        Engine actual = testCar.getEngine();
        assertNotSame("Engines must not refer to the same object.\n", actual, testEngine);
    }

    @Test
    public void engineEqualsTest() {
        Engine actual = testCar.getEngine();
        assertEquals("Engines must be equal.\n", actual, testEngine);
        assertNotEquals("Engines mustn't be equal.",null,actual);
    }

    @Test
    public void carEqualsTest() {
        Car car = new Car(2020, "white", testEngine);
        assertEquals("Cars must be equal.\n", car, testCar);
        assertNotEquals("Cars mustn't be equal.\n", null, testCar);
    }

    @Test
    public void engineIsNotEqualTest() {
        Engine actual = new Engine(200, "Manufacturer");
        assertNotEquals("Engines must be not equal.\n", actual, testEngine);
        actual = new Engine(100, "Fake Motors");
        assertNotEquals("Engines must be not equal.\n", actual, testEngine);
    }

    @Test
    public void getColor() {
        String year=testCar.getColor();
        assertEquals("white", year);
        Car newCar=testCar.setColor("red");
        assertEquals("white", year);
        assertEquals("red", newCar.getColor());
    }

    @Test
    public void setGetYearTest() {
        int year=testCar.getYear();
        assertEquals(2020, year);
        Car newCar=testCar.setYear(2021);
        assertEquals(2020, year);
        assertEquals(2021, newCar.getYear());
    }

    @Test
    public void setEngine() {
        Engine actual = testCar.getEngine();
        testCar.setEngine(actual);
        assertEquals("Engines must be not equal.\n", actual, testCar.getEngine());
        assertNotSame("Engines mustn't be equal.",testCar.getEngine(),actual);
    }

}