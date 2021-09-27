package com.home.urix.regform.config;


import com.home.urix.regform.model.BundleInjector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Slf4j
@Configuration
public class InternationalizationConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BundleInjector());
    }
    //    @Bean(name = "localeResolver")
//    public LocaleResolver getLocaleResolver()  {
////        CookieLocaleResolver resolver = new CookieLocaleResolver();
////        //By default, the locale resolver will obtain the locale code from the HTTP header. To force a default locale, we need to set it on the localeResolver():
////        resolver.setDefaultLocale(Locale.ENGLISH);
////        return resolver;
//        PageLocaleResolver resolver = new PageLocaleResolver();
//        return resolver;
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
////        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
////        localeInterceptor.setParamName("lang");
////        registry.addInterceptor(localeInterceptor).addPathPatterns("/*");
////        registry.addInterceptor(getLocalizationMessageInterceptor());
////
////        registry.addInterceptor(new MyInterceptorJustForTest());
////        registry.addInterceptor(new PageCookieInterceptor());
//
////        registry.addInterceptor(getLocalizationMessageInterceptor());
//
//    }
//
//
//    @Bean(name="siteMessages")
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource =
//                new ResourceBundleMessageSource();
//        messageSource.setBasename("i18n");
//        messageSource.setUseCodeAsDefaultMessage(true);
//        messageSource.setDefaultEncoding("UTF-8");
//        messageSource.setCacheSeconds(0);
//        return messageSource;
//    }
//
//    @Bean
//    public MustacheLocalizationMessageInterceptor getLocalizationMessageInterceptor() {
//        MustacheLocalizationMessageInterceptor lmi = new MustacheLocalizationMessageInterceptor();
//        lmi.setLocaleResolver(getLocaleResolver());
//        lmi.setMessageSource(messageSource());
//        return lmi;
//    }
}

//@Configuration
//public class InternationalizationConfig implements WebMvcConfigurer {
//
//    @Bean
//    public LocaleResolver localeResolver() {
//        return new CookieLocaleResolver();
//    }
//
//    @Bean
//    public LocaleChangeInterceptor localeInterceptor() {
//        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
//        localeInterceptor.setParamName("lang");
//        return localeInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeInterceptor());
//    }
//}