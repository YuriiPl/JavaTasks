package com.home.urix.lesson4;

public class View {

    public View() {

    }

    public void inputEnterGroupMessage() {
        System.out.println(TextFactory.getString("input.string.data.groupename"));
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

    public void printMessageById(String stringId){
        System.out.println(TextFactory.getString(stringId));
    }
}
