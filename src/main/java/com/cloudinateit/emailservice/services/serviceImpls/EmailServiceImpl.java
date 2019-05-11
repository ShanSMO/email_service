package com.cloudinateit.emailservice.services.serviceImpls;

import com.cloudinateit.emailservice.dtos.ResponseDto;
import com.cloudinateit.emailservice.models.Email;
import com.cloudinateit.emailservice.repositories.EmailRepository;
import com.cloudinateit.emailservice.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public ResponseDto sendMail(Email email) {
        emailRepository.saveAndFlush(email);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus("SUCCESS");
        responseDto.setMessage("Email sent");

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email.getMailTo());
        simpleMailMessage.setSubject(email.getSubject());
        simpleMailMessage.setText(email.getBody());
        javaMailSender.send(simpleMailMessage);
        return responseDto;
    }

    @Override
    public ResponseDto sendMailWithAttachment(Email email) {
        ResponseDto responseDto = new ResponseDto();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(email.getMailTo());
            mimeMessageHelper.setSubject(email.getSubject());
            mimeMessageHelper.setText(email.getBody());
            mimeMessageHelper.addAttachment("Test File", new File(""));
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return responseDto;
    }
}
