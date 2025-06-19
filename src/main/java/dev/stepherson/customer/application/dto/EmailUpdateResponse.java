package dev.stepherson.customer.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailUpdateResponse {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String message;

    public EmailUpdateResponse(String name, String email) {
        this.name = name;
        this.email = email;
        this.message = "Email updated successfully";
    }

}
