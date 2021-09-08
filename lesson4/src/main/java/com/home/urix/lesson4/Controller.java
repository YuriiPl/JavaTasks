package com.home.urix.lesson4;



import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * The main controller (MVC pattern) class
 * @author Plaksenkov Yurii
 * @version 0.0.1
 * @since 0.0.1
 */
public class Controller {
    private final NoteBook noteBook;
    private final View view;
    private ResourceBundle regexps;
    Scanner scanner;

    /**
     * Constructor
     * @param model
     * @param view
     */
    public Controller(NoteBook model, View view) {
        this.noteBook = model;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    /**
     * Main method.
     * It checks input, creates NoteBookRecord and puts this one to model
     * @since 0.0.1
     * @see NoteBookRecord
     */
    public void processRegistration(){
        String userInput;
        NoteBookRecord record = new NoteBookRecord();

        view.inputLastNameMessage();
        while(!checkLastName(userInput=scanner.nextLine())) {
            view.inputWrongDataMessage();
            view.inputLastNameMessage();
        }
        record.setLastname(userInput);

        view.inputFirstNameMessage();
        while(!checkFirstName(userInput=scanner.nextLine())) {
            view.inputWrongDataMessage();
            view.inputFirstNameMessage();
        }
        record.setFirstname(userInput);

        view.inputPatronymicMessage();
        while(!checkPatronomic(userInput=scanner.nextLine())) {
            view.inputWrongDataMessage();
            view.inputPatronymicMessage();
        }
        record.setPatronymic(userInput);


        //It needs refactoring
        record.setNickName(getNickName());

        view.inputCommentMessage();
        while(!checkComment(userInput=scanner.nextLine())) {
            view.inputWrongDataMessage();
            view.inputCommentMessage();
        }
        record.setComment(userInput);

        GroupsEnum group;
        view.inputEnterGroupMessage();
        while((group=toGroup(scanner.nextLine()))==GroupsEnum.UNKNOWN) {
            view.inputWrongDataMessage();
            view.inputEnterGroupMessage();
        }
        record.setGroup(group);

        view.inputHomePhoneMessage();
        while(!checkHomePhone(userInput=scanner.nextLine())) {
            view.inputWrongDataMessage();
            view.inputHomePhoneMessage();
        }
        record.setHomePhone(userInput);

        view.inputMobilePhoneMessage();
        while(!checkMobilePhone(userInput=scanner.nextLine())) {
            view.inputWrongDataMessage();
            view.inputMobilePhoneMessage();
        }
        record.setMobPhone(userInput);

        view.inputSecondMobilePhoneMessage();
        while(!checkMobilePhone2(userInput=scanner.nextLine())) {
            view.inputWrongDataMessage();
            view.inputSecondMobilePhoneMessage();
        }
        record.setSecondMobilePhone(userInput);

        view.inputEmailMessage();
        while(!checkEmail(userInput=scanner.nextLine())) {
            view.inputWrongDataMessage();
            view.inputEmailMessage();
        }
        record.setEmail(userInput);

        view.inputSkypeMessage();
        while(!checkSkype(userInput=scanner.nextLine())) {
            view.inputWrongDataMessage();
            view.inputSkypeMessage();
        }
        record.setSkype(userInput);

        NoteBookRecord.Address address = record.new Address();
        view.inputZipCodeMessage();
        while(!checkZipCode(userInput=scanner.nextLine())) {
            view.inputWrongDataMessage();
            view.inputZipCodeMessage();
        }
        address.setZipCode(userInput);

        view.inputCityMessage();
        while(!checkCity(userInput=scanner.nextLine())) {
            view.inputWrongDataMessage();
            view.inputCityMessage();
        }
        address.setCity(userInput);

        view.inputStreetMessage();
        while(!checkStreet(userInput=scanner.nextLine())) {
            view.inputWrongDataMessage();
            view.inputStreetMessage();
        }
        address.setStreet(userInput);

        view.inputHouseNumberMessage();
        while(!checkHouseNumber(userInput=scanner.nextLine())) {
            view.inputWrongDataMessage();
            view.inputHouseNumberMessage();
        }
        address.setHouseNum(userInput);

        view.inputFlatNumberMessage();
        while(!checkFlatNumber(userInput=scanner.nextLine())) {
            view.inputWrongDataMessage();
            view.inputFlatNumberMessage();
        }
        address.setFlatNum(userInput);

        record.setAddress(address);

        record.setInputDate(new Date());

        record.setChangedDate(new Date());

        boolean isNotInserted=true;
        while (isNotInserted) {
            try {
                noteBook.insertRecord(record);
                isNotInserted = false;
            } catch (LoginExistsException e) {
                view.loginExistsMessage();
                view.printString(e.getRecord().toString());
                record.setNickName(getNickName());
            }
        }

    }

    private String getNickName() {
        view.inputNicknameMessage();
        String userInput;
        while(!checkNickName(userInput=scanner.nextLine())) {
            view.inputWrongDataMessage();
            view.inputNicknameMessage();
        }
        return userInput;
    }

    /**
     * @param userInput User input from scanner
     * @return true if, and only if, userInput string matches the given regular expression
     */
    boolean checkLastName(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.lastname"));
    }

    /**
     * @param userInput User input from scanner
     * @return true if, and only if, userInput string matches the given regular expression
     */
    boolean checkFirstName(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.firstname"));
    }

    /**
     * @param userInput User input from scanner
     * @return true if, and only if, userInput string matches the given regular expression
     */
    boolean checkPatronomic(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.patronymic"));
    }

    /**
     * @param userInput User input from scanner
     * @return true if, and only if, userInput string matches the given regular expression
     */
    boolean checkNickName(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.nickname"));
    }

    /**
     * @param userInput User input from scanner
     * @return true if, and only if, userInput string matches the given regular expression
     */
    boolean checkComment(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.comment"));
    }

    /**
     * @param userInput User input from scanner
     * @return true if, and only if, userInput string matches the given regular expression
     */
    boolean checkHomePhone(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.homephonenumber"));
    }

    /**
     * @param userInput User input from scanner
     * @return true if, and only if, userInput string matches the given regular expression
     */
    boolean checkMobilePhone(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.homemobilenumber"));
    }

    /**
     * @param userInput User input from scanner
     * @return true if userInput string matches the given regular expression, or if userInput is empty
     */
    boolean checkMobilePhone2(String userInput){
        if(userInput.length()==0)return true;
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.homemobilenumber"));
    }

    /**
     * @param userInput User input from scanner
     * @return GroupsEnum. If userInput string doesn't match the given regular expression return GroupsEnum.ERROR_GROUP
     * @see GroupsEnum
     */
    GroupsEnum toGroup(String userInput){
        if (userInput.matches(TextFactory.getRegExpString("check.string.regexp.group.admin"))) return GroupsEnum.ADMIN;
        if (userInput.matches(TextFactory.getRegExpString("check.string.regexp.group.manager"))) return GroupsEnum.MANAGER;
        if (userInput.matches(TextFactory.getRegExpString("check.string.regexp.group.user"))) return GroupsEnum.USER;
        return GroupsEnum.UNKNOWN;
    }

    /**
     * @param userInput User input from scanner
     * @return true if, and only if, userInput string matches the given regular expression
     */
    boolean checkEmail(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.email"));
    }

    /**
     * @param userInput User input from scanner
     * @return true if, and only if, userInput string matches the given regular expression
     */
    boolean checkSkype(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.skype"));
    }

    /**
     * @param userInput User input from scanner
     * @return true if, and only if, userInput string matches the given regular expression
     */
    boolean checkZipCode(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.zipcode"));
    }

    /**
     * @param userInput User input from scanner
     * @return true if, and only if, userInput string matches the given regular expression
     */
    boolean checkCity(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.city"));
    }

    /**
     * @param userInput User input from scanner
     * @return true if, and only if, userInput string matches the given regular expression
     */
    boolean checkStreet(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.street"));
    }

    /**
     * @param userInput User input from scanner
     * @return true if, and only if, userInput string matches the given regular expression
     */
    boolean checkHouseNumber(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.housenumber"));
    }

    /**
     * @param userInput User input from scanner
     * @return true if userInput string matches the given regular expression, or if userInput is empty
     */
    boolean checkFlatNumber(String userInput){
        if(userInput.length()==0)return true;
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.flatnumber"));
    }

}
