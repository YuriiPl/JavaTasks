package com.home.urix;

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

        model.startGame();

        do {
            View.printGuessInRangeMessage(model.getLeftLimit(), model.getRightLimit());

            int userValue = getIntWithScanner();

            if (model.notInRange(userValue)) {
                View.printNotInRangeMessage(model.getLeftLimit(), model.getRightLimit());
                continue;
            }

            GuessResult result = model.checkResult(userValue);

            if(result == LESS)View.printLessMessage(userValue);

            if(result == MORE)View.printMoreMessage(userValue);

            if(result != EQUALS){
                model.changeLimits(userValue);
                View.printChangeLimitsMessage(model.getLeftLimit(), model.getRightLimit());
            }

        } while(model.gameInProcess());

        View.printWinMessage();

        printStat();
    }

    private void printStat() {
        int[] attempts = model.getAttempts();
        View.printAttempts(attempts);
    }

    public int getIntWithScanner() {
        View.printYourInputMessage();
        while(!scanner.hasNextInt()){
            View.printIncorrectInputMessage();
            View.printYourInputMessage();
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
}
