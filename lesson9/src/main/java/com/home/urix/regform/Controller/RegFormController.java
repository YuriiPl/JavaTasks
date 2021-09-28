package com.home.urix.regform.Controller;


import com.home.urix.regform.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(value = "/api")
public class RegFormController {

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/reg_form", method = RequestMethod.POST)
    public void registrationFormController(User note){

        log.info("{}", note);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HttpStatus> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
