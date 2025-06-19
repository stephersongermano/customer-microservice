package dev.stepherson.customer.domain.impl;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.stepherson.customer.application.dto.AddressRequest;
import dev.stepherson.customer.application.dto.CustomerRequest;
import dev.stepherson.customer.application.mapper.CustomerMapper;
import dev.stepherson.customer.domain.entity.Address;
import dev.stepherson.customer.domain.entity.Customer;
import dev.stepherson.customer.domain.repository.CustomerRepository;
import dev.stepherson.customer.domain.service.impl.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;
    private CustomerRequest customerRequest;
    private Customer customer;

    @BeforeEach
    public void setup() {
        Address address = Address.builder()
                .addressType("residential")
                .street("Acácias Street")
                .addressNumber("123")
                .complement("House 2")
                .neighborhood("Green Village")
                .city("Curitiba")
                .state("PR")
                .postalCode("80540-000")
                .country("Brazil")
                .isPrimary(true)
                .build();

        AddressRequest addressRequest = AddressRequest.builder()
                .addressType("residential")
                .street("Acácias Street")
                .addressNumber("123")
                .complement("House 2")
                .neighborhood("Green Village")
                .city("Curitiba")
                .state("PR")
                .postalCode("80540-000")
                .country("Brazil")
                .primary(true)
                .build();

        customerRequest = CustomerRequest.builder().name("John Silva")
                .email("jonh.silva@email.com")
                .phoneNumber("123456789")
                .document("172.416.970-06")
                .addresses(List.of(addressRequest))
                .build();

        customer = Customer.builder().name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .phoneNumber(customerRequest.getPhoneNumber())
                .document(customerRequest.getDocument())
                .addresses(List.of(address))
                .build();

        Mockito.when(customerMapper.toCustomer(Mockito.any(CustomerRequest.class))).thenReturn(customer);

    }

    @Test
    public void whenCreateClient_thenSaveClient() {
        Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(customer);

        customerServiceImpl.create(customerRequest);

        Mockito.verify(customerRepository, Mockito.times(1)).save(Mockito.any(Customer.class));
    }

}
