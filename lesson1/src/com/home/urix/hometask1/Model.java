package com.home.urix.hometask1;

public class Model {

    // The Constants
    private static final String HELLO = "Hello";
    private static final String WORLD = "world";

    private String hello, world;

    public void setFirstWord(String world) {
        this.world = world;
    }

    public void setSecondWord(String hello) {
        this.hello = hello;
    }

    public String getResult() {
        return "\"" + hello + " " + world + "!\"\n";
    }

    public boolean firstWordIsNOtAccept(String word) {
        return !HELLO.equals(word);
    }

    public boolean secondWordIsNOtAccept(String word) {
        return !WORLD.equals(word);
    }

    public String expectedFirstWord() {
        return HELLO;
    }

    public String expectedSecondWord() {
        return WORLD;
    }
}
