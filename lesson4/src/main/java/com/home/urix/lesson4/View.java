package com.home.urix.lesson4;

public class View {

    public View() {

    }

    public void inputLastNameMessage() {
        System.out.println(TextFactory.getString("input.string.data.lastname"));
    }

    public void inputFirstNameMessage() {
        System.out.println(TextFactory.getString("input.string.data.firstname"));
    }

    public void inputPatronymicMessage() {
        System.out.println(TextFactory.getString("input.string.data.patronymic"));
    }

    public void inputNicknameMessage() {
        System.out.println(TextFactory.getString("input.string.data.nickname"));
    }

    public void inputCommentMessage() {
        System.out.println(TextFactory.getString("input.string.data.comment"));
    }

    public void inputEnterGroupMessage() {
        System.out.println(TextFactory.getString("input.string.data.groupename"));
    }

    public void inputHomePhoneMessage() {
        System.out.println(TextFactory.getString("input.string.data.phone.number"));
    }

    public void inputMobilePhoneMessage() {
        System.out.println(TextFactory.getString("input.string.data.phone.mobile.number"));
    }

    public void inputSecondMobilePhoneMessage() {
        System.out.println(TextFactory.getString("input.string.data.phone.mobile.number.opt"));
    }

    public void inputEmailMessage() {
        System.out.println(TextFactory.getString("input.string.data.email"));
    }

    public void inputSkypeMessage() {
        System.out.println(TextFactory.getString("input.string.data.skype"));
    }

    public void inputZipCodeMessage() {
        System.out.println(TextFactory.getString("input.string.data.address.zipcode"));
    }

    public void inputCityMessage() {
        System.out.println(TextFactory.getString("input.string.data.address.city"));
    }

    public void inputStreetMessage() {
        System.out.println(TextFactory.getString("input.string.data.address.street"));
    }

    public void inputHouseNumberMessage() {
        System.out.println(TextFactory.getString("input.string.data.address.housenumber"));
    }

    public void inputFlatNumberMessage() {
        System.out.println(TextFactory.getString("input.string.data.address.flatnumber"));
    }

    public void inputWrongDataMessage() {
        System.out.println(TextFactory.getString("input.string.data.wrong"));
    }

    public void loginExistsMessage(){
        System.out.println(TextFactory.getString("errors.string.login.exists"));
    }

    public void printString(String str){
        System.out.println(str);
    }
}
