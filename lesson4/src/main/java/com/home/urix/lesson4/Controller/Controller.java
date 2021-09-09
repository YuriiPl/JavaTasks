package com.home.urix.lesson4.Controller;



import com.home.urix.lesson4.Model.GroupsEnum;
import com.home.urix.lesson4.Model.LoginExistsException;
import com.home.urix.lesson4.Model.NoteBook;
import com.home.urix.lesson4.Model.NoteBookRecord;
import com.home.urix.lesson4.View.TextConstant;
import com.home.urix.lesson4.View.TextFactory;
import com.home.urix.lesson4.View.View;

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

    private String getStringFromScanner(String messageResourceBundleId, String regexpResourceBundleId){
        String currentRegExp = TextFactory.getRegExpString(regexpResourceBundleId);
        view.printMessageById(messageResourceBundleId);
        String userInput = scanner.nextLine();
        while(!userInput.matches(currentRegExp)) {
            view.inputWrongDataMessage();
            view.printMessageById(messageResourceBundleId);
            userInput = scanner.nextLine();
        }
        return userInput;
    }

    /**
     * Main method.
     * It checks input, creates NoteBookRecord and puts this one to the model
     * @since 0.0.1
     * @see NoteBookRecord
     */
    public void processRegistration(){
        String userInput;
        NoteBookRecord record = new NoteBookRecord();

        record.setLastname(getStringFromScanner(TextConstant.LAST_NAME,RegexContainer.REGEX_LAST_NAME));

        record.setFirstname(getStringFromScanner(TextConstant.FIRST_NAME,RegexContainer.REGEX_FIRST_NAME));

        record.setPatronymic(getStringFromScanner(TextConstant.PATRONYMIC,RegexContainer.REGEX_PATRONYMIC));

        record.setNickName(getStringFromScanner(TextConstant.NICKNAME,RegexContainer.REGEX_NICKNAME));

        record.setComment(getStringFromScanner(TextConstant.COMMENT,RegexContainer.REGEX_COMMENT));

        //need to come up with something original
        GroupsEnum group;
        view.inputEnterGroupMessage();
        while((group=toGroup(scanner.nextLine()))==GroupsEnum.UNKNOWN) {
            view.inputWrongDataMessage();
            view.inputEnterGroupMessage();
        }
        record.setGroup(group);

        record.setHomePhone(getStringFromScanner(TextConstant.PHONE_NUMBER,RegexContainer.REGEX_HOME_MOBILE_PHONE_NUMBER));

        record.setMobPhone(getStringFromScanner(TextConstant.PHONE_MOBILE_NUMBER,RegexContainer.REGEX_HOME_MOBILE_PHONE_NUMBER));

        record.setSecondMobilePhone(getStringFromScanner(TextConstant.PHONE_MOBILE_NUMBER_OPTIONAL,RegexContainer.REGEX_HOME_MOBILE_PHONE_NUMBER_OPT));

        record.setEmail(getStringFromScanner(TextConstant.EMAIL_DATA,RegexContainer.REGEX_EMAIL));

        record.setSkype(getStringFromScanner(TextConstant.SKYPE_DATA,RegexContainer.REGEX_SKYPE));

        NoteBookRecord.Address address = record.new Address();

        address.setZipCode(getStringFromScanner(TextConstant.ZIPCODE_DATA,RegexContainer.REGEX_ZIPCODE));

        address.setCity(getStringFromScanner(TextConstant.CITY_DATA,RegexContainer.REGEX_CITY));

        address.setStreet(getStringFromScanner(TextConstant.STREET_DATA,RegexContainer.REGEX_STREET));

        address.setHouseNum(getStringFromScanner(TextConstant.HOUSE_NUMBER_DATA,RegexContainer.REGEX_HOUSE_NUMBER));

        address.setFlatNum(getStringFromScanner(TextConstant.FLAT_NUMBER_DATA,RegexContainer.REGEX_HOUSE_FLAT_NUMBER));

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
                //record.setNickName(getNickName()); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                record.setNickName(getStringFromScanner(TextConstant.NICKNAME,RegexContainer.REGEX_NICKNAME));
            }
        }

    }

    /**
     * @param userInput User input from scanner
     * @return GroupsEnum. If userInput string doesn't match the given regular expression return GroupsEnum.ERROR_GROUP
     * @see GroupsEnum
     */
    GroupsEnum toGroup(String userInput){
        if (userInput.matches(TextFactory.getRegExpString(RegexContainer.REGEX_ADMIN))) return GroupsEnum.ADMIN;
        if (userInput.matches(TextFactory.getRegExpString(RegexContainer.REGEX_MANAGER))) return GroupsEnum.MANAGER;
        if (userInput.matches(TextFactory.getRegExpString(RegexContainer.REGEX_USER))) return GroupsEnum.USER;
        return GroupsEnum.UNKNOWN;
    }

}
