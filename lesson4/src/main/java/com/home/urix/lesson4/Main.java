package com.home.urix.lesson4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Main {
    public static void main(String ... args){
        Locale locale = new Locale("uk","UA");
        //TextFactory.changeLocale(locale);
        Controller controller = new Controller(new Model(), new View());
        controller.processRegistration();

    }
}
