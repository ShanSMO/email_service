package com.cloudinateit.emailservice.controllers;

import com.cloudinateit.emailservice.dtos.ResponseDto;
import com.cloudinateit.emailservice.models.Email;
import com.cloudinateit.emailservice.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "send", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> sendMail(@RequestBody Email email) {
        ResponseDto responseDto = emailService.sendMail(email);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

}
