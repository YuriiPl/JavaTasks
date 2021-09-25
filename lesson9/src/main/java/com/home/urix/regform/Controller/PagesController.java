package com.home.urix.regform.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PagesController {

    @RequestMapping("/")
    public String mainPage(){
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
}
