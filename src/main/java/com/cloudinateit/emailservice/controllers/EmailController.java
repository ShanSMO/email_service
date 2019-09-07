package com.cloudinateit.emailservice.controllers;

import com.cloudinateit.emailservice.dtos.ResponseDto;
import com.cloudinateit.emailservice.models.Email;
import com.cloudinateit.emailservice.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Value("${name}")
    private String userName;

    @RequestMapping(value = "send", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> sendMail(@RequestBody Email email) {
        ResponseDto responseDto = emailService.sendMail(email);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping(value = "test-config")
    public String testConfig() {
        return  userName;
    }

}
