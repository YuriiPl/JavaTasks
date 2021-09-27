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


    @GetMapping("/")
    public String mainPage(Model model)
    {
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
    public ResponseEntity<HttpStatus> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
