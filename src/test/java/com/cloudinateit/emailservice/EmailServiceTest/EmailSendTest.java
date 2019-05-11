package com.cloudinateit.emailservice.EmailServiceTest;

import com.cloudinateit.emailservice.models.Email;
import com.cloudinateit.emailservice.services.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailSendTest {

    @Autowired
    EmailService emailService;

    @Test
    public void sendEmail() {
        Email email = new Email();
        email.setMailTo("osmali.sandu@gmail.com");
        email.setSubject("Gon Balli");
        email.setBody("Balapan yako oya email eka.wadiri");
        email.setMailFrom("Ubata Wedak Nane");
        emailService.sendMail(email);
    }

    @Test
    public void sendMailWithAttachment() {
        Email email = new Email();
        email.setAttachment("");
        emailService.sendMail(email);
    }

}
