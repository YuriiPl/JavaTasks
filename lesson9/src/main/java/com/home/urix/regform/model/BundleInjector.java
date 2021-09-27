package com.home.urix.regform.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Slf4j
@Component
public class BundleInjector implements HandlerInterceptor {
    private final String EN="en";
    private final String UK_UA="uk_UA";

    HashMap<String, ResourceBundle> bundleHashMap;

    public BundleInjector() {
        bundleHashMap = new HashMap<>();
        bundleHashMap.put(EN,ResourceBundle.getBundle("i18n", Locale.ENGLISH));
        bundleHashMap.put(UK_UA,ResourceBundle.getBundle("i18n", new Locale("uk","UA")));
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView==null)return;
        String lang;
        try {
            lang=Arrays.stream(request.getCookies())
                    .filter(c -> Objects.equals(c.getName(), "lang"))
                    .map(Cookie::getValue)
                    .filter(s->Arrays.asList(EN,UK_UA).contains(s))
                    .findFirst().orElse(EN);
        } catch (NullPointerException e){
            lang=EN;
        }
        modelAndView.addObject("i18n",bundleHashMap.get(lang));

//        log.info(bundleHashMap.get(lang).);
    }
}
