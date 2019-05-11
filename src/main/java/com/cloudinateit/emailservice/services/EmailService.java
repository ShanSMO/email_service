package com.cloudinateit.emailservice.services;

import com.cloudinateit.emailservice.dtos.ResponseDto;
import com.cloudinateit.emailservice.models.Email;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmailService {

    ResponseDto sendMail(Email email);
    ResponseDto sendMailWithAttachment(Email email);
}
