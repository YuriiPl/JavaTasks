package com.home.urix.JavaGame;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.Scanner;

public class Controller {
    Scanner scanner;
    private final Model model;
    private final View view;


    public Controller(Model model, View view){
        this.model=model;
        this.view=view;
        scanner = new Scanner(System.in);
    }

    void startGame(){
        View.printMessage(View.GREETINGS_MESSAGE);
        boolean guessed=false;
        while(guessed==false) {
            View.printMessage(View.GUESS_IN_RANGE_MESSAGE, model.getLeftLimit(), model.getRightLimit());

            int value = getIntWithScanner();

            if (model.isNotInRange(value)) {
                View.printMessage(View.NOT_IN_RANGE_MESSAGE, model.getLeftLimit(), model.getRightLimit());
                continue;
            }

            if(model.isBigger(value)){
                View.printMessage(View.LESS_MESSAGE,value);
            }

            if(model.isSmaller(value)){
                View.printMessage(View.MORE_MESSAGE,value);
            }

            if (model.isGuessed(value)) {
                guessed=true;
                View.printMessage(View.WIN_MESSAGE);
            } else {
                model.changeLimits(value);
                View.printMessage(View.CHANGE_LIMITS_MESSAGE, model.getLeftLimit(), model.getRightLimit());
            }

            showStatistics();

            model.saveStat(value);
        }
    }

    private void showStatistics() {
        int[] values =model.getStats();
        if(values.length==0)return;
        View.printMessage(View.PREVIOUSLY_START_MESSAGE);
        for (int value : values) {
            View.printMessage(View.YOUR_INPUT_MESSAGE);
            View.printMessage(value + " ");
            if (model.isBigger(value)) {
                View.printMessage(View.LESS_MESSAGE, value);
            }
            if (model.isSmaller(value)) {
                View.printMessage(View.MORE_MESSAGE, value);
            }
        }
        View.printMessage(View.PREVIOUSLY_END_MESSAGE);
    }

    public int getIntWithScanner() {
        View.printMessage(View.YOUR_INPUT_MESSAGE);
        while(scanner.hasNextInt()==false){
            View.printMessage(View.INCORRECT_INPUT_MESSAGE);
            View.printMessage(View.YOUR_INPUT_MESSAGE);
            scanner.nextLine();
        }
        return scanner.nextInt();

    }
}
