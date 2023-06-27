package com.ms.msemail.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ms.msemail.enums.StatusEmail;
import com.ms.msemail.model.EmailModel;
import com.ms.msemail.repository.EmailRepository;

@Service
public class EmailService {
    
    @Autowired
    private EmailRepository repository;

    @Autowired
    private JavaMailSender mailSender;

    @Transactional
    public EmailModel sendEmail(EmailModel model) {
        EmailModel saved = null;

        model.setSendDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(model.getEmailFrom());
            message.setTo(model.getEmailTo());
            message.setSubject(model.getSubject());
            message.setText(model.getText());
            mailSender.send(message);

            model.setStatusEmail(StatusEmail.SENT);
        } catch (MailException me) {
            model.setStatusEmail(StatusEmail.ERROR);
        } finally {
            saved = repository.save(model);
        }

        return saved;
    }

}
