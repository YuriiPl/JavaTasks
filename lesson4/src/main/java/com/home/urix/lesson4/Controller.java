package com.home.urix.lesson4;



import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;
    private ResourceBundle regexps;
    Scanner scanner;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        regexps = ResourceBundle.getBundle("regexps", view.currentLocale());
        scanner = new Scanner(System.in);
    }

    public void processRegistration(){
        view.inputLastNameMessage();
        String userInput;
        while(checkLastName(userInput=scanner.nextLine()));
        model.setSetLastName(userInput);

    }

    boolean checkLastName(String userInput){
        return userInput.matches(regexps.getString("check.string.regexp.lastname"));
    }

    boolean checkFirstName(String userInput){
        return userInput.matches(regexps.getString("check.string.regexp.firstname"));
    }
}
