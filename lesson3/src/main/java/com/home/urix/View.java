package com.home.urix;

import java.util.ArrayList;
import java.util.Arrays;

public class View {

    public static final String GREETINGS_MESSAGE = "Hello! This is a really cool game! Let's start!\n";
    public static final String GUESS_IN_RANGE_MESSAGE="Guess the number in the range (%1,%2)\n";
    public static final String NOT_IN_RANGE_MESSAGE="Number isn't in the range (%1,%2)\n";
    public static final String YOUR_INPUT_MESSAGE="Your input: ";
    public static final String INCORRECT_INPUT_MESSAGE="Input is incorrect. Integer expected\n";
    public static final String MORE_MESSAGE="My number is more than %1\n";
    public static final String LESS_MESSAGE="My number is less than %1\n";
    public static final String CHANGE_LIMITS_MESSAGE="And now, the limits look like this: (%1,%2)\n";
    public static final String WIN_MESSAGE="You guessed! You're a winner! Congratulations!\n";
    public static final String PREVIOUSLY_START_MESSAGE="*** PREVIOUSLY ***\n";
    public static final String PREVIOUSLY_END_MESSAGE="\n***";

    static public void printGreeting(){
        System.out.print(GREETINGS_MESSAGE);
    }

    public static void printYourInputMessage() {
        System.out.print(YOUR_INPUT_MESSAGE);
    }

    public static void printIncorrectInputMessage() {
        System.out.print(INCORRECT_INPUT_MESSAGE);
    }

    public static void printGuessInRangeMessage(int leftLimit, int rightLimit) {
        System.out.print(GUESS_IN_RANGE_MESSAGE.replace("%1",String.valueOf(leftLimit)).replace("%2",String.valueOf(rightLimit)));
    }

    public static void printNotInRangeMessage(int leftLimit, int rightLimit) {
        System.out.print(NOT_IN_RANGE_MESSAGE.replace("%1",String.valueOf(leftLimit)).replace("%2",String.valueOf(rightLimit)));
    }

    public static void printLessMessage(int value) {
        System.out.print(LESS_MESSAGE.replace("%1",String.valueOf(value)));
    }

    public static void printMoreMessage(int value) {
        System.out.print(MORE_MESSAGE.replace("%1",String.valueOf(value)));
    }

    public static void printWinMessage() {
        System.out.print(WIN_MESSAGE);
    }

    public static void printChangeLimitsMessage(int leftLimit, int rightLimit) {
        System.out.print(CHANGE_LIMITS_MESSAGE.replace("%1",String.valueOf(leftLimit)).replace("%2",String.valueOf(rightLimit)));
    }

    public static void printAttempts(ArrayList<Integer> attempts) {
        System.out.print(PREVIOUSLY_START_MESSAGE);
        System.out.print(attempts.toString());
        System.out.print(PREVIOUSLY_END_MESSAGE);
    }
}
