package dev.stepherson.customer.application.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import dev.stepherson.customer.application.dto.AddressRequest;
import dev.stepherson.customer.application.dto.AddressResponse;
import dev.stepherson.customer.application.dto.CustomerRequest;
import dev.stepherson.customer.application.dto.CustomerResponse;
import dev.stepherson.customer.application.dto.EmailUpdateResponse;
import dev.stepherson.customer.application.dto.PhoneNumberUpdateResponse;
import dev.stepherson.customer.domain.entity.Address;
import dev.stepherson.customer.domain.entity.Customer;
import dev.stepherson.customer.exception.PrimaryAddressNotFoundException;
import dev.stepherson.customer.util.Document;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request) {

        List<Address> addresses = request.getAddresses().stream().map(this::toAddress).collect(Collectors.toList());

        String documentRemovedMaks = Document.removeMask(request.getDocument());

        return new Customer(request.getName(), request.getEmail(), request.getPhoneNumber(), documentRemovedMaks,
                addresses);

    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(customer.getId(), customer.getName(), customer.getEmail(),
                customer.getPhoneNumber(), customer.getDocument(), toPrimaryAddressResponse(customer.getAddresses()));
    }

    public EmailUpdateResponse toEmailUpdateResponse(Customer customer) {
        return new EmailUpdateResponse(customer.getName(), customer.getEmail());
    }

    public PhoneNumberUpdateResponse toPhoneNumberUpdateResponse(Customer customer) {
        return new PhoneNumberUpdateResponse(customer.getName(), customer.getPhoneNumber());
    }

    private Address toAddress(AddressRequest request) {
        return Address.builder()
                .addressType(request.getAddressType().toUpperCase())
                .street(request.getStreet().toUpperCase())
                .addressNumber(request.getAddressNumber())
                .complement(request.getComplement().toUpperCase())
                .neighborhood(request.getNeighborhood().toUpperCase())
                .city(request.getCity().toUpperCase())
                .state(request.getState().toUpperCase())
                .postalCode(request.getPostalCode())
                .country(request.getCountry().toUpperCase())
                .isPrimary(request.isPrimary())
                .build();
    }

    private AddressResponse toPrimaryAddressResponse(List<Address> addresses) {
        return addresses.stream()
                .filter(Address::isPrimary)
                .findFirst()
                .map(primaryAddress -> AddressResponse.builder()
                        .addressType(primaryAddress.getAddressType())
                        .street(primaryAddress.getStreet())
                        .addressNumber(primaryAddress.getAddressNumber())
                        .complement(primaryAddress.getComplement())
                        .neighborhood(primaryAddress.getNeighborhood())
                        .city(primaryAddress.getCity())
                        .state(primaryAddress.getState())
                        .postalCode(primaryAddress.getPostalCode())
                        .country(primaryAddress.getCountry())
                        .build())
                .orElseThrow(PrimaryAddressNotFoundException::new);
    }
}
