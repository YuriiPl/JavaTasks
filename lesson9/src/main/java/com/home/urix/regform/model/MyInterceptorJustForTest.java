package com.home.urix.regform.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
public class MyInterceptorJustForTest implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
//        log.info("Interceptor 1, вызывается перед запросом, то есть перед вызовом метода контроллера.");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
//        log.info("Interceptor 2, вызывается после запроса, до визуализации представления, то есть после вызова метода контроллера");

//        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
//        assert localeResolver != null;
//        Locale locale = localeResolver.resolveLocale(request);
//        Cookie[] cookies = request.getCookies();
//        String cookiesStr= Arrays.stream(cookies).map(c -> c.getName()+"="+c.getValue()).collect(Collectors.joining("; "));
//        log.info(locale +" "+ cookiesStr);

//        StringBuilder newLocale = new StringBuilder();
//        for (Enumeration<String> e = request.getParameterNames(); e.hasMoreElements();)
//            newLocale.append(e.nextElement());
//        log.info(newLocale.toString()+" "+request.getClass().getName());

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        //log.info ("Interceptor 3. Он вызывается после завершения запроса, в основном используется для очистки.");
    }

}