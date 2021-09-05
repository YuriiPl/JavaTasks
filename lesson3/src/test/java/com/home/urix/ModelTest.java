package com.home.urix;


import org.junit.*;

import java.util.Arrays;
import java.util.Random;

import static com.home.urix.GuessResult.*;

public class ModelTest {

    private Model model;
    private int value;

    @Before
    public void initModel(){
        this.model = new Model();
        this.value = model.initGame();
    }

    @Test
    public void startGameTest() {
        for (int i=0;i<500;i++) {
            Assert.assertTrue(value>0 && value<100);
        }
    }

    @Test
    public void gameInProcessStartTest() {
        Assert.assertTrue(model.gameInProcess());
    }

    @Test
    public void gameInProcessFinishTest() {
        model.processUserInput(value);
        Assert.assertFalse(model.gameInProcess());
    }

    @Test
    public void getLeftLimitStartTest() {
        Assert.assertEquals(model.getLeftLimit(),0);
    }

    @Test
    public void getLeftLimitInProcessTest() {
        while(value<2){value=model.initGame();}
        model.processUserInput(value-1);
        Assert.assertEquals(model.getLeftLimit(),value-1);
    }

    @Test
    public void getRightLimitStartTest() {
        Assert.assertEquals(model.getRightLimit(),100);
    }

    @Test
    public void getRightLimitInProcessTest() {
        while(value>98){value=model.initGame();}
        model.processUserInput(value+1);
        Assert.assertEquals(model.getRightLimit(),value+1);
    }

    @Test
    public void notInRangeOutRangeTest() {
        Random rnd =new Random();
        for(int i=0;i<500;i++){
            Assert.assertTrue(model.notInRange(rnd.nextInt(Integer.MAX_VALUE-100)+100));
            Assert.assertTrue(model.notInRange(-rnd.nextInt()));
        }
    }

    @Test
    public void notInRangeInRangeTest() {
        Random rnd =new Random();
        for(int i=0;i<500;i++){
            Assert.assertFalse(model.notInRange(rnd.nextInt(99)+1));
        }
    }

    @Test
    public void notInRangeChangeRightLimitTest() {
        while(value>97){value=model.initGame();}
        model.processUserInput(value+1);
        Assert.assertTrue(model.notInRange(value+1));
        model.processUserInput(value+2);
        Assert.assertTrue(model.notInRange(value+2));
        Assert.assertFalse(model.notInRange(value));
    }

    @Test
    public void notInRangeChangeLeftLimitTest() {
        while(value<3){value=model.initGame();}
        model.processUserInput(value-1);
        Assert.assertTrue(model.notInRange(value-1));
        model.processUserInput(value-2);
        Assert.assertTrue(model.notInRange(value-2));
        Assert.assertFalse(model.notInRange(value));
    }


    @Test
    public void checkResultTest() {
        Assert.assertEquals(model.processUserInput(value), EQUALS);
        Assert.assertEquals(model.processUserInput(value+1), MANY);
        Assert.assertEquals(model.processUserInput(value-1), FEW);
    }

    @Test
    public void getAttemptsTest() {
        model.processUserInput(10);
        model.processUserInput(50);
        model.processUserInput(70);
        Assert.assertArrayEquals(model.getAttempts().toArray(), Arrays.asList(10,50,70).toArray());
    }
}