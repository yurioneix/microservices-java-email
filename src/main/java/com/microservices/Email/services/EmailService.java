package com.microservices.Email.services;

import com.microservices.Email.enums.StatusEmail;
import com.microservices.Email.models.EmailModel;
import com.microservices.Email.repositories.EmailRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  final EmailRepository emailRepository;
  final JavaMailSender emailSender;

  public EmailService(EmailRepository emailRepository, JavaMailSender emailSender) {
    this.emailRepository = emailRepository;
    this.emailSender = emailSender;
  }

  @Value(value = "${spring.mail.username}")
  private String emailFrom;

  @Transactional
  public EmailModel sendEmail(EmailModel emailModel) {
    try {
      emailModel.setSendDateEmail(LocalDateTime.now());
      emailModel.setEmailFrom(emailFrom);

      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(emailModel.getEmailTo());
      message.setSubject(emailModel.getSubject());
      message.setText(emailModel.getText());
      emailSender.send(message);

      emailModel.setStatusEmail(StatusEmail.SENT);
    } catch (MailException e) {
      emailModel.setStatusEmail(StatusEmail.ERROR);
    } finally {
      return emailRepository.save(emailModel);
    }
  }
}
