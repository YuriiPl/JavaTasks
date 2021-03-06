package com.home.urix.regform.Controller;

import com.home.urix.regform.entity.UserDto;
import com.home.urix.regform.repos.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class PagesController {

    private final UserRepository userRepo;

    @Autowired
    public PagesController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

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
    public String regForm(Model model){
        return "reg_form";
    }

    @RequestMapping("/users")
    public String showUsers(Model model){
        Iterable<UserDto> all = userRepo.findAll();
        model.addAttribute("users",all);
        return "userslist";
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HttpStatus> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
