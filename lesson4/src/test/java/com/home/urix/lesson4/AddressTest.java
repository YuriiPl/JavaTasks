package com.home.urix.lesson4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

public class AddressTest {

    Controller controller;

    @Before
    public void before(){
        Locale locale = new Locale("us","US");
        TextFactory.changeLocale(locale);
        controller = new Controller(new NoteBook(),new View());
    }

    @Test
    public void checkCityTest_ok_us() {
        for (String str: new String[]{"New York","San-Francisco", "Niagara on the Lake", "Chicago", "St. Catharines" }
        ) {
            Assert.assertTrue(str,controller.checkCity(str));
        }
    }

    @Test
    public void checkCityTest_false_us() {
        for (String str: new String[]{" Chicago", "San-", "San.", ".San"}
        ) {
            Assert.assertFalse(str,controller.checkCity(str));
        }
    }

}