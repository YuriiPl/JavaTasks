package com.home.urix.regform.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Map;

@Controller
public class PagesController {

    @RequestMapping("/")
    public String mainPage(Map<String,Object> model)
    {
        model.put("titlemainpage","PagesController");
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
