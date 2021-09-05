package com.home.urix.lesson4;



import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller {
    private NoteBook noteBook;
    private View view;
    private ResourceBundle regexps;
    Scanner scanner;

    public Controller(NoteBook model, View view) {
        this.noteBook = model;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    public void processRegistration(){
        String userInput;
        NoteBookRecord record = new NoteBookRecord();

        view.inputLastNameMessage();
        while(!checkLastName(userInput=scanner.nextLine()))view.inputLastNameMessage();
        record.setLastname(userInput);

        view.inputFirstNameMessage();
        while(!checkFirstName(userInput=scanner.nextLine()))view.inputFirstNameMessage();
        record.setFirstname(userInput);

        view.inputPatronymicMessage();
        while(!checkPatronomic(userInput=scanner.nextLine()))view.inputPatronymicMessage();
        record.setPatronymic(userInput);

        view.inputNicknameMessage();
        while(!checkNickName(userInput=scanner.nextLine()))view.inputNicknameMessage();
        record.setNickName(userInput);

        view.inputCommentMessage();
        while(!checkComment(userInput=scanner.nextLine()))view.inputCommentMessage();
        record.setComment(userInput);

        GroupsEnum group;
        view.inputEnterGroupMessage();
        while((group=toGroup(scanner.nextLine()))==GroupsEnum.ERROR_GROUP)view.inputEnterGroupMessage();
        record.setGroup(group);

        view.inputHomePhoneMessage();
        while(!checkHomePhone(userInput=scanner.nextLine()))view.inputHomePhoneMessage();
        record.setHomePhone(userInput);

        view.inputMobilePhoneMessage();
        while(!checkMobilePhone(userInput=scanner.nextLine()))view.inputMobilePhoneMessage();
        record.setMobPhone(userInput);

        view.inputSecondMobilePhoneMessage();
        while(!checkMobilePhone2(userInput=scanner.nextLine()))view.inputSecondMobilePhoneMessage();
        record.setSecondMobilePhone(userInput);

        view.inputEmailMessage();
        while(!checkEmail(userInput=scanner.nextLine()))view.inputEmailMessage();
        record.setEmail(userInput);

        view.inputSkypeMessage();
        while(!checkSkype(userInput=scanner.nextLine()))view.inputSkypeMessage();
        record.setSkype(userInput);

        NoteBookRecord.Address address = record.new Address();
        view.inputZipCodeMessage();
        while(!checkZipCode(userInput=scanner.nextLine()))view.inputZipCodeMessage();
        address.setZipCode(userInput);

        view.inputCityMessage();
        while(!checkCity(userInput=scanner.nextLine()))view.inputCityMessage();
        address.setCity(userInput);

        view.inputStreetMessage();
        while(!checkStreet(userInput=scanner.nextLine()))view.inputStreetMessage();
        address.setStreet(userInput);

        view.inputHouseNumberMessage();
        while(!checkHouseNumber(userInput=scanner.nextLine()))view.inputHouseNumberMessage();
        address.setHouseNum(userInput);

        view.inputFlatNumberMessage();
        while(!checkFlatNumber(userInput=scanner.nextLine()))view.inputFlatNumberMessage();
        address.setFlatNum(userInput);

        record.setAddress(address);

        record.setInputDate(new Date());

        record.setChangedDate(new Date());

        noteBook.insertRecord(record);

    }

    boolean checkLastName(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.lastname"));
    }

    boolean checkFirstName(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.firstname"));
    }

    boolean checkPatronomic(String userInput){
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.patronymic"));
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

    boolean checkZipCode(String userInput){
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

    boolean checkFlatNumber(String userInput){
        if(userInput.length()==0)return true;
        return userInput.matches(TextFactory.getRegExpString("check.string.regexp.flatnumber"));
    }

}
