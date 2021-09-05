package com.home.urix.lesson4;

import java.util.Locale;

public class Main {
    public static void main(String ... args){
        Locale locale = new Locale("uk","UA");
        TextFactory.changeLocale(locale);
        Controller controller = new Controller(new NoteBook(), new View());
        controller.processRegistration();

    }
}
