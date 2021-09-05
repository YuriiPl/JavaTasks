package com.home.urix.lesson4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

public class CheckSkypeTest {

    Controller controller;

    @Before
    public void before(){
        Locale locale = new Locale("uk","UA");
        TextFactory.changeLocale(locale);
        controller = new Controller(new NoteBook(),new View());
    }


    @Test
    public void checkSkypeTest() {
        for (String str: new String[]{"Sdddk.rddr", "Skype.Skype", "Skype1"}
        ) {
            Assert.assertTrue(str,controller.checkSkype(str));
        }
    }
}