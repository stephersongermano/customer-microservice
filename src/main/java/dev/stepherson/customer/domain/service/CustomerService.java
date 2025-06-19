package dev.stepherson.customer.domain.service;

import java.util.UUID;

import dev.stepherson.customer.application.dto.CustomerRequest;
import dev.stepherson.customer.application.dto.CustomerResponse;
import dev.stepherson.customer.application.dto.EmailUpdateResponse;
import dev.stepherson.customer.application.dto.PhoneNumberUpdateResponse;

public interface CustomerService {
    CustomerResponse create(CustomerRequest request);

    CustomerResponse findByDocument(String document);

    CustomerResponse findById(UUID id);

    EmailUpdateResponse updateEmail(UUID id, String email);

    PhoneNumberUpdateResponse updatePhoneNumber(UUID id, String phoneNumber);

    void delete(UUID id);
}
