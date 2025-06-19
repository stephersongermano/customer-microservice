package dev.stepherson.customer.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.stepherson.customer.domain.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    @Query("SELECT c FROM Customer c WHERE c.document = :document")
    Optional<Customer> findByDocument(String document);

}
