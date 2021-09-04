package com.home.urix.lesson4;



import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {
    private Model model;
    private View view;
    private ResourceBundle regexps;
    Scanner scanner;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    public void processRegistration(){
//        view.inputLastNameMessage();
//        String userInput;
//        while(checkLastName(userInput=scanner.nextLine()));
//        model.setSetLastName(userInput);

        System.out.println(Pattern.matches(TextFactory.getRegExpString("check.string.regexp.midname"),""));

    }

    boolean checkLastName(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.lastname"));
    }

    boolean checkFirstName(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.firstname"));
    }

    boolean checkMidName(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.midname"));
    }

    boolean checkNickName(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.nickname"));
    }

    boolean checkComment(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.comment"));
    }

    boolean checkHomePhone(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.homephonenumber"));
    }

    boolean checkMobilePhone(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.homemobilenumber"));
    }

    boolean checkMobilePhone2(String userInput){
        if(userInput.length()==0)return true;
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.homemobilenumber"));
    }

    GroupsEnum toGroup(String userInput){
        if (TextFactory.getRegExpString("check.string.regexp.group.admin").equals(userInput)) return GroupsEnum.ADMIN;
        if (TextFactory.getRegExpString("check.string.regexp.group.manager").equals(userInput)) return GroupsEnum.MANAGER;
        if (TextFactory.getRegExpString("check.string.regexp.group.user").equals(userInput)) return GroupsEnum.USER;
        return GroupsEnum.ERROR_GROUP;
    }

    boolean checkEmail(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.email"));
    }

    boolean checkSkype(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.skype"));
    }

    boolean checkIndex(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.zipcode"));
    }

    boolean checkCity(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.city"));
    }

    boolean checkStreet(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.street"));
    }

    boolean checkHouseNumber(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.housenumber"));
    }

}
