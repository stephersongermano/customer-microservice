package dev.stepherson.customer.application.validation;

import dev.stepherson.customer.util.Document;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CPFOrCNPJValidator implements ConstraintValidator<IsCPFOrCNPJValid, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return Document.isValidCPFOrCNPJ(value);
    }
}