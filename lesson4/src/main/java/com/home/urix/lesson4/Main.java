package com.home.urix.lesson4;

import com.home.urix.lesson4.Controller.Controller;
import com.home.urix.lesson4.Model.NoteBook;
import com.home.urix.lesson4.View.TextFactory;
import com.home.urix.lesson4.View.View;

import java.util.Locale;

public class Main {
    public static void main(String ... args){
        Locale locale = new Locale("uk","UA");
        TextFactory.changeLocale(locale);
        Controller controller = new Controller(new NoteBook(), new View());
        controller.processRegistration();

    }
}
