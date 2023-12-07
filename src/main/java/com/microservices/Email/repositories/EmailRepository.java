package com.microservices.Email.repositories;

import com.microservices.Email.models.EmailModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {

}
