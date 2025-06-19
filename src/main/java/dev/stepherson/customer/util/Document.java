package dev.stepherson.customer.util;

public final class Document {

    /**
     * Validates if a document is a valid CPF or CNPJ.
     */
    public static boolean isValidCPFOrCNPJ(String document) {

        if (document == null)
            return false;

        String numericDoc = removeMask(document);

        if (numericDoc.length() == 11) {
            System.out.println(isValidCNPJ(numericDoc));
            return isValidCPF(numericDoc);
        }

        if (numericDoc.length() == 14) {
            return isValidCNPJ(numericDoc);
        }

        return false;

    }

    /**
     * Removes non-numeric characters from the document
     */
    public static String removeMask(String document) {
        if (document == null)
            return "";

        return document.replaceAll("\\D", "");
    }

    /**
     * Validates a CPF (11 digits)
     */
    public static boolean isValidCPF(String cpf) {
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // First validatation (10th digit)
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }

        int remainder = sum % 11;
        int calculatedDigit = (remainder < 2) ? 0 : 11 - remainder;

        if (Character.getNumericValue(cpf.charAt(9)) != calculatedDigit) {
            return false;
        }

        // Second validation (11th digit)
        sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }

        int remainder2 = sum % 11;
        int calculatedDigit2 = (remainder2 < 2) ? 0 : 11 - remainder2;

        if (Character.getNumericValue(cpf.charAt(10)) != calculatedDigit2) {
            return false;
        }

        return true;

    }

    /**
     * Validates a CNPJ (14 digits).
     */
    public static boolean isValidCNPJ(String cnpj) {
        if (cnpj.length() != 14 || cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        // Weights to verify first digit
        int[] weightsFirst = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

        // Weights to verify second digit
        int[] weightsSecond = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

        // First Digit
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += Character.getNumericValue(cnpj.charAt(i)) * weightsFirst[i];
        }

        int remainder = sum % 11;
        int calculatedDigit = (remainder < 2) ? 0 : 11 - remainder;

        if (Character.getNumericValue(cnpj.charAt(12)) != calculatedDigit) {
            return false;
        }

        // Second Digit
        sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += Character.getNumericValue(cnpj.charAt(i)) * weightsSecond[i];
        }

        remainder = sum % 11;
        calculatedDigit = (remainder < 2) ? 0 : 11 - remainder;

        if (Character.getNumericValue(cnpj.charAt(13)) != calculatedDigit) {
            return false;
        }

        return true;

    }
}
