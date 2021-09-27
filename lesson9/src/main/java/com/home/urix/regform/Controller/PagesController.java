package com.home.urix.regform.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.ResourceBundle;

@Slf4j
@Controller
public class PagesController {

//    final MessageSource messageSource;

//    public PagesController(@Qualifier("siteMessages") MessageSource messageSource) {
//        this.messageSource = messageSource;
//    }

    @GetMapping("/")
    public String mainPage(Model model)
    {
//        model.addAttribute("title", messageSource. getMessage("title", new Object[0], Locale.ENGLISH));
//        model.addAttribute("message", messageSource. getMessage("message", new Object[0], Locale.forLanguageTag("uk_UA")));
        //model.addAttribute("msg", ResourceBundle.getBundle("i18n",new Locale("uk_UA")));
        //<div>${msg["message"]}</div>
        return "index";
    }

    @RequestMapping("/api")
    public String apiPage(){
        return "index";
    }

    @RequestMapping("/form")
    public String regForm(){
        return "reg_form";
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
