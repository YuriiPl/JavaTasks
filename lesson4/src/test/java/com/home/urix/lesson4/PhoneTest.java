package com.home.urix.lesson4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

public class PhoneTest {

    Controller controller;

    @Before
    public void before(){
        controller = new Controller(new NoteBook(),new View());
    }

    @Test
    public void checkHomePhoneTest_ua() {
        Locale locale = new Locale("uk","UA");
        TextFactory.changeLocale(locale);
        for (String str: new String[]{"(04444)333-33-33", "+38(04444)333-33-33", "(044)333-33-33", "+38(044)333-33-33" }
        ) {
            Assert.assertTrue(str,controller.checkHomePhone(str));
        }
    }

    @Test
    public void checkHomePhoneTest_usa() {
        for (String str: new String[]{"215.223.1234", "805 931 1234", "335 931-4288", "1-(805) 523-1234" }
        ) {
            Assert.assertTrue(str,controller.checkHomePhone(str));
        }
    }

}