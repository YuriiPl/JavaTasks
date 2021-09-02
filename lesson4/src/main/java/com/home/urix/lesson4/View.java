package com.home.urix.lesson4;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    private final ResourceBundle messageBundle;

    public View(Locale locale) {
        this.messageBundle = ResourceBundle.getBundle("messages", locale);
    }

    Locale currentLocale(){
        return messageBundle.getLocale();
    }

    void inputLastNameMessage(){
        System.out.println(messageBundle.getString(TextConstant.ENTER_LAST_NAME_MESSAGE));
    }
}
