package com.home.urix.lesson4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

public class LastNameTest {

    Controller controller;

    @Before
    public void before(){
        Locale locale = new Locale("uk","UA");
        TextFactory.changeLocale(locale);
        controller = new Controller(new NoteBook(),new View());
    }

    @Test
    public void checkLastName_standard() {
        for (String str: new String[]{"Петренко", "Василенко", "Рогульчик"}
        ) {
            Assert.assertTrue(str,controller.checkLastName(str));
        }
    }

    @Test
    public void checkLastName_standard_space() {
        for (String str: new String[]{"Петренко ", "Васи ленко", " Рогульчик"}
        ) {
            Assert.assertFalse(str,controller.checkLastName(str));
        }
    }

    @Test
    public void checkLastName_standard_number() {
        for (String str: new String[]{"Петренко23", "Василе1нко", "17Рогульчик"}
        ) {
            Assert.assertFalse(str,controller.checkLastName(str));
        }
    }

    @Test
    public void checkLastName_ukrainian_apostrophe () {
        for (String str: new String[]{"Пом'янчук", "Дерев'яненко", "П'ятенко"}
        ) {
            Assert.assertTrue(str,controller.checkLastName(str));
        }
    }

    @Test
    public void checkLastName_ukrainian_double_apostrophe () {
        for (String str: new String[]{"Пом'янч'ук", "П'ятен'ко", "Дерев'янен'ко-П'ятен'ко"}
        ) {
            Assert.assertFalse(str,controller.checkLastName(str));
        }
    }

    @Test
    public void checkLastName_ukrainian_apostrophe_borders () {
        for (String str: new String[]{"'Петренко", "Петренко'", "'Петренко'"}
        ) {
            Assert.assertFalse(str,controller.checkLastName(str));
        }
    }

    @Test
    public void checkLastName_russian_signs () {
        for (String str: new String[]{"Подъёмов", "Объездов", "Ёжиков", "Эбуталылов", "Эскандэров", "Евдышеев", "Бабарэк"}
        ) {
            Assert.assertFalse(str,controller.checkLastName(str));
        }
    }

    @Test
    public void checkLastName_hyphen () {
        for (String str: new String[]{"Нечуй-Левицький"}
        ) {
            Assert.assertTrue(str,controller.checkLastName(str));
        }
    }

    @Test
    public void checkLastName_hyphen_small () {
        for (String str: new String[]{"Нечуй-левицький"}
        ) {
            Assert.assertFalse(str,controller.checkLastName(str));
        }
    }

    @Test
    public void checkLastName_hyphen_small_apostrophe_many () {
        for (String str: new String[]{"Нечуй---Левицький","П''''ятенко","М'яка----П'''ятенко"}
        ) {
            Assert.assertFalse(str,controller.checkLastName(str));
        }
    }

    @Test
    public void checkLastName_hyphen_apostrophe () {
        for (String str: new String[]{"Нечуй-'Левицький","П'-ятенко","М'яка'-'П'ятенко","Мяка'-'Пятенко"}
        ) {
            Assert.assertFalse(str,controller.checkLastName(str));
        }
    }

    @Test
    public void checkLastName_hyphen_double_apostrof () {
        for (String str: new String[]{"М'яка-П'ятенко","П'ятенко-М'яка"}
        ) {
            Assert.assertTrue(str,controller.checkLastName(str));
        }
    }

    @Test
    public void checkLastName_ukrainian_specific() {
        for (String str: new String[]{"Помінчук", "Сергієнко", "Їжаченко", "Іванченко", "Єресько"}
        ) {
            Assert.assertTrue(str,controller.checkLastName(str));
        }
    }

    @Test
    public void checkLastName_ukrainian_specific_g() {
        for (String str: new String[]{"Ґончар", "Уґнівенко", "Ґончар-Уґнівенко"}
        ) {
            Assert.assertTrue(str,controller.checkLastName(str));
        }
    }
}