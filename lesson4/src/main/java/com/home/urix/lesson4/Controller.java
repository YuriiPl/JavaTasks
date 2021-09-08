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

        record.setLastname(getStringFromScanner("input.string.data.lastname","check.string.regexp.lastname"));

        record.setFirstname(getStringFromScanner("input.string.data.firstname","check.string.regexp.firstname"));

        record.setPatronymic(getStringFromScanner("input.string.data.patronymic","check.string.regexp.patronymic"));

        record.setNickName(getStringFromScanner("input.string.data.nickname","check.string.regexp.nickname"));

        record.setComment(getStringFromScanner("input.string.data.comment","check.string.regexp.comment"));

        //need to come up with something original
        GroupsEnum group;
        view.inputEnterGroupMessage();
        while((group=toGroup(scanner.nextLine()))==GroupsEnum.UNKNOWN) {
            view.inputWrongDataMessage();
            view.inputEnterGroupMessage();
        }
        record.setGroup(group);

        record.setHomePhone(getStringFromScanner("input.string.data.phone.number","check.string.regexp.homephonenumber"));

        record.setMobPhone(getStringFromScanner("input.string.data.phone.mobile.number","check.string.regexp.homemobilenumber"));

        record.setSecondMobilePhone(getStringFromScanner("input.string.data.phone.mobile.number.opt","check.string.regexp.homemobilenumber.opt"));

        record.setEmail(getStringFromScanner("input.string.data.email","check.string.regexp.email"));

        record.setSkype(getStringFromScanner("input.string.data.skype","check.string.regexp.skype"));

        NoteBookRecord.Address address = record.new Address();

        address.setZipCode(getStringFromScanner("input.string.data.address.zipcode","check.string.regexp.zipcode"));

        address.setCity(getStringFromScanner("input.string.data.address.city","check.string.regexp.city"));

        address.setStreet(getStringFromScanner("input.string.data.address.street","check.string.regexp.street"));

        address.setHouseNum(getStringFromScanner("input.string.data.address.housenumber","check.string.regexp.housenumber"));

        address.setFlatNum(getStringFromScanner("input.string.data.address.flatnumber","check.string.regexp.flatnumber"));

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
                record.setNickName(getStringFromScanner("input.string.data.nickname","check.string.regexp.nickname"));
            }
        }

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

}
