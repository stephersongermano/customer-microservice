package dev.stepherson.customer.domain.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.stepherson.customer.application.dto.CustomerRequest;
import dev.stepherson.customer.application.dto.CustomerResponse;
import dev.stepherson.customer.application.dto.EmailUpdateResponse;
import dev.stepherson.customer.application.dto.PhoneNumberUpdateResponse;
import dev.stepherson.customer.application.mapper.CustomerMapper;
import dev.stepherson.customer.domain.entity.Customer;
import dev.stepherson.customer.domain.repository.CustomerRepository;
import dev.stepherson.customer.exception.DocumentAlreadyExistsException;
import dev.stepherson.customer.exception.IdNotFoundExcepiton;
import dev.stepherson.customer.exception.UnregisteredDocument;
import dev.stepherson.customer.util.DocumentMaskingUtil;
import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Transactional
    public CustomerResponse create(CustomerRequest request) {
        Optional<Customer> existingCustomer = this.customerRepository.findByDocument(request.getDocument());

        if (existingCustomer.isPresent()) {
            throw new DocumentAlreadyExistsException(DocumentMaskingUtil.maskDocument(request.getDocument()));
        }

        Customer customer = this.customerMapper.toCustomer(request);

        this.customerRepository.save(customer);

        return this.customerMapper.toCustomerResponse(customer);
    }

    @Transactional
    public CustomerResponse findByDocument(String document) {
        Customer customer = this.customerRepository.findByDocument(document)
                .orElseThrow(() -> new UnregisteredDocument(document));

        return this.customerMapper.toCustomerResponse(customer);
    }

    @Transactional
    public CustomerResponse findById(UUID id) {
        Customer customer = this.customerRepository.findById(id).orElseThrow(() -> new IdNotFoundExcepiton(id));

        return this.customerMapper.toCustomerResponse(customer);
    }

    @Transactional
    public EmailUpdateResponse updateEmail(UUID id, String email) {
        Customer customer = this.customerRepository.findById(id).orElseThrow(() -> new IdNotFoundExcepiton(id));

        customer.setEmail(email);

        this.customerRepository.save(customer);

        return this.customerMapper.toEmailUpdateResponse(customer);
    }

    @Transactional
    public PhoneNumberUpdateResponse updatePhoneNumber(UUID id, String phoneNumber) {
        Customer customer = this.customerRepository.findById(id).orElseThrow(() -> new IdNotFoundExcepiton(id));

        customer.setPhoneNumber(phoneNumber);

        this.customerRepository.save(customer);

        return this.customerMapper.toPhoneNumberUpdateResponse(customer);

    }

    @Transactional
    public void delete(UUID id) {
        Customer customer = this.customerRepository.findById(id).orElseThrow(() -> new IdNotFoundExcepiton(id));

        customer.markAsDeleted();

        this.customerRepository.save(customer);
    }
}
