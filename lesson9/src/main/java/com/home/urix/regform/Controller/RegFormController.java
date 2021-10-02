package com.home.urix.regform.Controller;


import com.home.urix.regform.entity.User;
import com.home.urix.regform.repos.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


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

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String,Set<String>>> handleConstraintViolationException(DataIntegrityViolationException ex) {
        log.warn("{} {}", ex.getClass(), ex.getLocalizedMessage());
        return new ResponseEntity<>(Collections.singletonMap("message",Collections.singleton("user_email_exist")), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String,Set<String>>> handleRuntimeException(ConstraintViolationException ex) {
        log.warn("{} {}", ex.getClass(), ex.getLocalizedMessage());
        Set<String> collect = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());
        return new ResponseEntity<>(Collections.singletonMap("message",collect), HttpStatus.CONFLICT);
    }
}
