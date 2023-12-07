package com.microservices.Email.consumers;

import com.microservices.Email.dtos.EmailRecordDto;
import com.microservices.Email.models.EmailModel;
import com.microservices.Email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

  final EmailService emailService;

  public EmailConsumer(EmailService emailService) {
    this.emailService = emailService;
  }

  @RabbitListener(queues = "${broker.queue.email.name}")
  public void listenEmailQueue(@Payload EmailRecordDto emailRecordDto) {
    EmailModel newEmail = new EmailModel();
    BeanUtils.copyProperties(emailRecordDto, newEmail);
    emailService.sendEmail(newEmail);
  }
}
