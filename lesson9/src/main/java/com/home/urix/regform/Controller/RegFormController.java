package com.home.urix.regform.Controller;


import com.home.urix.regform.dto.User;
import com.home.urix.regform.repos.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(value = "/api")
public class RegFormController {

    private final UserRepository userRepo;

    @Autowired
    public RegFormController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/reg_form", method = RequestMethod.POST)
    public void registrationFormController(User user){
        userRepo.save(user);
        log.info("{}", user);
    }

//    @ResponseStatus(
//            value = HttpStatus.CONFLICT,
//            reason = "User with this email already exists"
//    )
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity("{\"message\": \"User ${i18n[title]} with this email already exists\"}", HttpStatus.CONFLICT);
    }
}
