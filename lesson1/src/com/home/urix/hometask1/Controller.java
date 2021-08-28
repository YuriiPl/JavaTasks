package com.home.urix.hometask1;

import java.util.Scanner;

public class Controller {

    final private Model model;
    final private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        String word1, word2;
        Scanner scanner = new Scanner(System.in);
        view.printMessage(View.MESSAGE_ASK_HELLO);
        while (model.firstWordIsNOtAccept(word1 = getWordWithScanner(scanner))) {
            view.printMessage(View.MESSAGE_ERROR + model.expectedFirstWord() + " (" + word1 + ") ");
        }
        view.printMessage(View.MESSAGE_ASK_WORLD);
        while (model.secondWordIsNOtAccept(word2 = getWordWithScanner(scanner))) {
            view.printMessage(View.MESSAGE_ERROR + model.expectedSecondWord() + " (" + word2 + ") ");
        }
        model.setSecondWord(word1);
        model.setFirstWord(word2);

        view.printMessageAndString(View.MESSAGE_RESULT, model.getResult());
    }

    public String getWordWithScanner(Scanner sc) {
        return sc.next();
    }

}
