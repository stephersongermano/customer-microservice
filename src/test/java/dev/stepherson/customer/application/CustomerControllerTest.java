package dev.stepherson.customer.application;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.stepherson.customer.application.controller.CustomerController;
import dev.stepherson.customer.application.dto.AddressRequest;
import dev.stepherson.customer.application.dto.AddressResponse;
import dev.stepherson.customer.application.dto.CustomerRequest;
import dev.stepherson.customer.application.dto.CustomerResponse;
import dev.stepherson.customer.application.mapper.CustomerMapper;
import dev.stepherson.customer.domain.entity.Address;
import dev.stepherson.customer.domain.entity.Customer;
import dev.stepherson.customer.domain.service.impl.CustomerServiceImpl;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private CustomerServiceImpl customerServiceImpl;

    @MockitoBean
    private CustomerMapper customerMapper;

    private CustomerRequest customerRequest;
    private CustomerResponse customerResponse;
    private Customer customer;

    @BeforeEach
    public void setup() {

        UUID uuid = UUID.randomUUID();

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

        AddressResponse addressResponse = AddressResponse.builder()
                .addressType("residential")
                .street("Acácias Street")
                .addressNumber("123")
                .complement("House 2")
                .neighborhood("Green Village")
                .city("Curitiba")
                .state("PR")
                .postalCode("80540-000")
                .country("Brazil")
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

        customerResponse = CustomerResponse.builder().id(uuid)
                .name(customer.getName())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .document(customer.getDocument())
                .address(addressResponse)
                .build();

        when(customerMapper.toCustomer(any(CustomerRequest.class))).thenReturn(customer);
        when(customerMapper.toCustomerResponse(any(Customer.class))).thenReturn(customerResponse);

    }

    @Test
    public void testCreateCustomer() throws Exception {
        when(customerServiceImpl.create(any(CustomerRequest.class))).thenReturn(customerResponse);

        mockMvc.perform(post("/customers").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(customerResponse.getId().toString()))
                .andExpect(jsonPath("$.name").value(customerResponse.getName()))
                .andExpect(jsonPath("$.email").value(customerResponse.getEmail()))
                .andExpect(jsonPath("$.document").value(customerResponse.getDocument()))
                .andExpect(jsonPath("$.address").value(customerResponse.getAddress()));
    }

    @Test
    public void testeCreateCustomer_InvalidDocument() throws Exception {
        CustomerRequest invalidRequest = CustomerRequest.builder()
                .name("John Silva")
                .email("jonh.silva@email.com")
                .phoneNumber("123456789")
                .document("11112133150")
                .addresses(List.of(AddressRequest.builder()
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
                        .build()))
                .build();

        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath(".fieldErrors.document").value("Document must be a valid CPF or CNPJ."));
    }

}
