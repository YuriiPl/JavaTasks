//package com.home.urix.regform.model;
//
//import lombok.NonNull;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.MessageSource;
//import org.springframework.context.MessageSourceAware;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.LocaleResolver;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.StringWriter;
//import java.io.Writer;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//import java.util.function.Function;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//
//@Slf4j
//public class MustacheLocalizationMessageInterceptor implements MessageSourceAware, HandlerInterceptor {
//    public static final String DEFAULT_MODEL_KEY = "i18n";
//    private static final Pattern KEY_PATTERN = Pattern.compile("(.*?)[\\s\\[]");
//    private static final Pattern ARGS_PATTERN = Pattern.compile("\\[(.*?)\\]");
//    private String messageKey = DEFAULT_MODEL_KEY;
//    private MessageSource messageSource;
//    private LocaleResolver localeResolver;
//
//    public MustacheLocalizationMessageInterceptor() {
//    }
//
//    protected final void localize(HttpServletRequest request, String frag, Writer out) throws IOException {
//        Locale locale = localeResolver.resolveLocale(request);
//        String key = extractKey(frag);
//        List<String> args = extractParameters(frag);
//        String text = messageSource.getMessage(key, args.toArray(), locale);
//        out.write(text);
//        log.info("localize: "+key+" "+String.join(";", args)+" "+locale);
//    }
//
//    protected Object createHelper(final HttpServletRequest request) {
//        return (Function<String, String>) input -> {
//            final StringWriter out = new StringWriter();
//            try {
//                localize(request, input, out);
//            } catch (IOException e) {
//                log.info(e.getMessage());
//                throw new RuntimeException(e);
//            }
//            return out.toString();
//        };
//    }
//
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//        if(modelAndView!=null)
//            log.info(modelAndView.getViewName()+" "+messageKey);
//
//    }
//
//    private String extractKey(String key) {
//        Matcher matcher = KEY_PATTERN.matcher(key);
//        return matcher.find() ? matcher.group(1) : key;
//    }
//
//    private List<String> extractParameters(String key) {
//        Matcher matcher = ARGS_PATTERN.matcher(key);
//        ArrayList<String> args = new ArrayList<>();
//
//        while(matcher.find()) {
//            args.add(matcher.group(1));
//        }
//
//        return args;
//    }
//
//    public void setMessageKey(String messageKey) {
//        this.messageKey = messageKey;
//    }
//
//    public void setMessageSource(MessageSource messageSource) {
//        this.messageSource = messageSource;
//    }
//
//    public void setLocaleResolver(LocaleResolver localeResolver) {
//        this.localeResolver = localeResolver;
//    }
//}