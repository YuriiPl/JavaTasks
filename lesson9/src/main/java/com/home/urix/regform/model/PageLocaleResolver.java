//package com.home.urix.regform.model;
//
//
//import org.springframework.web.servlet.LocaleResolver;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Arrays;
//import java.util.Locale;
//import java.util.Objects;
//
//
//public class PageLocaleResolver implements LocaleResolver {
//
//    @Override
//    public Locale resolveLocale(HttpServletRequest request) {
//        Cookie[] cookies=request.getCookies();
//        if(cookies==null)return Locale.ENGLISH;
//        String localeValue=Arrays.stream(cookies)
//                .filter(c -> Objects.equals(c.getName(), "lang"))
//                .map(Cookie::getValue)
//                .findFirst().orElse("en");
//        return Locale.forLanguageTag(localeValue);
//    }
//
//    @Override
//    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
//
//    }
//}
