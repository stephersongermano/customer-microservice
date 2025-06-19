package dev.stepherson.customer.application.dto;

import java.util.UUID;

import dev.stepherson.customer.util.DocumentMaskingUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {

    private UUID id;
    private String name;
    private String email;
    private String phoneNumber;
    private String document;
    private AddressResponse address;

    public void markSensitiveData() {
        this.document = DocumentMaskingUtil.maskDocument(this.document);
    }
}