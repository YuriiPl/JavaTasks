//package com.home.urix.regform.model;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.util.StringUtils;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.support.RequestContextUtils;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Arrays;
//import java.util.Locale;
//import java.util.Objects;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Slf4j
//public class PageCookieInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////        Cookie[] cookies = request.getCookies();
////        if(cookies==null)return true;
////        Optional<Cookie> cookie=Arrays.stream(cookies).filter(c -> Objects.equals(c.getName(), "lang")).findFirst();
////        if(cookie.isPresent()){
////            String localeValue=cookie.get().getValue().equals("uk_UA")?"uk_UA":"en";
////            LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
////            if (localeResolver == null) {
////                log.info("No LocaleResolver found: not in a DispatcherServlet request?");
////                throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
////            }
////            try {
////                localeResolver.setLocale(request, response, StringUtils.parseLocale(localeValue));
////            } catch (IllegalArgumentException ignore) {
////            }
////        }
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
////        Cookie[] cookies = request.getCookies();
////        if(cookies!=null) {
////            log.info(Arrays.stream(request.getCookies()).map(cookie -> cookie.getName() + "=" + cookie.getValue()).collect(Collectors.joining(";")));
////        } else {
////            log.info("No cookie");
////        }
////        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
////        if(modelAndView==null)return;
////        modelAndView.addObject("titlemainpage","PageCookieInterceptor");
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }
//}
