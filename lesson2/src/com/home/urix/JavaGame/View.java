package com.home.urix.JavaGame;

import jdk.nashorn.internal.runtime.QuotedStringTokenizer;

public class View {
    public static final String GREETINGS_MESSAGE = "Hello! This is a really cool game! Let's start!\n";
    public static final String GUESS_IN_RANGE_MESSAGE="Guess the number in the range [%1,%2]\n";
    public static final String NOT_IN_RANGE_MESSAGE="Number isn't in the range (%1,%2)\n";
    public static final String YOUR_INPUT_MESSAGE="Your input: ";
    public static final String INCORRECT_INPUT_MESSAGE="Input is incorrect. Integer expected\n";
    public static final String MORE_MESSAGE="My number is more than %1\n";
    public static final String LESS_MESSAGE="My number is less than %1\n";
    public static final String CHANGE_LIMITS_MESSAGE="And now, the limits look like this: [%1,%2]\n";
    public static final String WIN_MESSAGE="You guessed! You're a winner! Congratulations!\n";
    public static final String PREVIOUSLY_START_MESSAGE="*** PREVIOUSLY ***\n";
    public static final String PREVIOUSLY_END_MESSAGE="***\n";

    public static void printMessage(String message, int ... params){
        for(int i=1;i<=params.length;i++) {
            message = message.replaceAll("%"+i,String.valueOf(params[i-1]) );
        }
        System.out.print(message);
    }
}
