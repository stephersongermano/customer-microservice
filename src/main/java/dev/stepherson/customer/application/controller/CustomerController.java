package dev.stepherson.customer.application.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.stepherson.customer.application.dto.CustomerRequest;
import dev.stepherson.customer.application.dto.CustomerResponse;
import dev.stepherson.customer.application.dto.EmailUpdateResponse;
import dev.stepherson.customer.application.dto.PhoneNumberUpdateResponse;
import dev.stepherson.customer.domain.service.impl.CustomerServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;

    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@Valid @RequestBody CustomerRequest request) {
        var response = this.customerServiceImpl.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable UUID id) {
        var response = this.customerServiceImpl.findById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/email")
    public ResponseEntity<EmailUpdateResponse> updateEmail(@PathVariable UUID id, @RequestBody String email) {
        var resposne = this.customerServiceImpl.updateEmail(id, email);
        return ResponseEntity.ok(resposne);
    }

    @PutMapping("{id}/phone")
    public ResponseEntity<PhoneNumberUpdateResponse> updatePhoneNumber(@PathVariable UUID id,
            @RequestBody String email) {
        var response = this.customerServiceImpl.updatePhoneNumber(id, email);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable UUID id) {
        this.customerServiceImpl.delete(id);
    }
}
