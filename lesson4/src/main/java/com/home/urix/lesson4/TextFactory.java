package com.home.urix.lesson4;

import java.util.Locale;
import java.util.ResourceBundle;

public class TextFactory {
    static private ResourceBundle messages;
    static private ResourceBundle regexps;
    static {
        messages = ResourceBundle.getBundle("messages");
        regexps = ResourceBundle.getBundle("regexps");
    }
    static public void changeLocale(Locale locale){
        messages = ResourceBundle.getBundle("messages",locale);
        regexps = ResourceBundle.getBundle("regexps",locale);
    }

    static public String getString(String str){
        if(messages.containsKey(str))
            return messages.getString(str);
        return messages.getString("input.string.unknown.id")+str;
    }

    static public String getRegExpString(String str){
        return regexps.getString(str);
    }
}
