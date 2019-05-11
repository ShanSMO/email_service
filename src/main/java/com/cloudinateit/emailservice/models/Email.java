package com.cloudinateit.emailservice.models;

import com.cloudinateit.emailservice.enums.EmailSendStatus;

import javax.persistence.*;

@Entity
@Table(name = "tbl_email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "mail_from")
    private String mailFrom;

    @Column(name = "mail_to")
    private String mailTo;

    @Column(name = "subject")
    private String subject;

    @Column(name = "body")
    private String body;

    @Column(name = "attachment")
    private String attachment;

    @Column(name = "send_status")
    @Enumerated
    private EmailSendStatus emailSendStatus;

    @Column(name = "retired_count")
    private Integer retriedCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public EmailSendStatus getEmailSendStatus() {
        return emailSendStatus;
    }

    public void setEmailSendStatus(EmailSendStatus emailSendStatus) {
        this.emailSendStatus = emailSendStatus;
    }

    public Integer getRetriedCount() {
        return retriedCount;
    }

    public void setRetriedCount(Integer retriedCount) {
        this.retriedCount = retriedCount;
    }
}
