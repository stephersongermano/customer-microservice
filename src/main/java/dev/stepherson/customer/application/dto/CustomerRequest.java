package dev.stepherson.customer.application.dto;

import java.util.List;

import dev.stepherson.customer.application.validation.IsCPFOrCNPJValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerRequest {

    @NotBlank(message = "Name is required.")
    private String name;

    @NotBlank(message = "Email is required.")
    @Email
    private String email;

    @NotBlank(message = "Phone Number is required.")
    private String phoneNumber;

    @NotBlank(message = "Document is required.")
    @IsCPFOrCNPJValid(message = "Document must be a valid CPF or CNPJ.")
    private String document;

    @NotEmpty(message = "At least one address is required.")
    private List<AddressRequest> addresses;
}
