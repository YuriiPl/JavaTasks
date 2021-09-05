package com.home.urix;

import java.util.ArrayList;
import java.util.Scanner;

import static com.home.urix.GuessResult.*;


public class Controller {
    Model model;
    View view;
    Scanner scanner;

    public Controller(Model model, View view) {
        this.model=model;
        this.view=view;
        scanner = new Scanner(System.in);
    }

    void startGame(){
        View.printGreeting();

        model.initGame();

        do {
            View.printGuessInRangeMessage(model.getLeftLimit(), model.getRightLimit());

            int userValue = getIntWithScanner();

            if (model.notInRange(userValue)) {
                View.printNotInRangeMessage(model.getLeftLimit(), model.getRightLimit());
                continue;
            }

            GuessResult result = model.processUserInput(userValue);

            if(result == MANY)View.printLessMessage(userValue);

            if(result == FEW)View.printMoreMessage(userValue);

            if(result != EQUALS){
                View.printChangeLimitsMessage(model.getLeftLimit(), model.getRightLimit());
            }

        } while(model.gameInProcess());

        View.printWinMessage();

        printStat();
    }

    private void printStat() {
        ArrayList<Integer> attempts = model.getAttempts();
        View.printAttempts(attempts);
    }

    public int getIntWithScanner() {
        View.printYourInputMessage();
        while(!scanner.hasNextInt()){
            View.printIncorrectInputMessage();
            View.printYourInputMessage();
            while(scanner.nextLine().equals(""));
        }
        return scanner.nextInt();
    }
}
