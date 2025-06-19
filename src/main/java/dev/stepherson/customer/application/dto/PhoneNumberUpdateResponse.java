package dev.stepherson.customer.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumberUpdateResponse {

    private String name;
    private String phoneNumber;
    private String message;

    public PhoneNumberUpdateResponse(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.message = "Phone number updated successfully";
    }

}
