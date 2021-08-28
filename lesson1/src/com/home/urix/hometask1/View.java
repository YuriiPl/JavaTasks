package com.home.urix.hometask1;

public class View {
    public static final String MESSAGE_RESULT = "Result=";
    public static final String MESSAGE_ERROR = "Wrong word. Expected ";
    public static final String MESSAGE_ASK_HELLO = "Input \"Hello\" word: ";
    public static final String MESSAGE_ASK_WORLD = "Input \"world\" word: ";

    public void printMessageAndString(String msg, String result) {
        System.out.print(msg + result);
    }

    public void printMessage(String str) {
        System.out.print(str);
    }
}
