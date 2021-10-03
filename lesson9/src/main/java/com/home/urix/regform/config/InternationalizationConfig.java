package com.home.urix.regform.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;


@Slf4j
@Configuration
public class InternationalizationConfig implements WebMvcConfigurer {

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
        bundleMessageSource.setBasenames("i18n");
        bundleMessageSource.setDefaultEncoding("UTF-8");
        return bundleMessageSource;
    }

    @Bean
    public LocaleResolver localeResolver(){
        CookieLocaleResolver lr = new CookieLocaleResolver();
        lr.setCookieName("lang");
        return lr;
    }

//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("lang");
//        return localeChangeInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(localeChangeInterceptor());
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new BundleInjector());
//    }


}
