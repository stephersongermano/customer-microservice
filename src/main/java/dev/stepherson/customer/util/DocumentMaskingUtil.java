package dev.stepherson.customer.util;

public final class DocumentMaskingUtil {

    /**
     * Masks a document (CPF or CNPJ) to show only the first 2 and last 2 digits.
     * If the document is null or too short, returns a default mask.
     */
    public static String maskDocument(String document) {
        if (document == null || document.length() < 4) {
            return "***********";
        }

        int length = document.length();
        int visibleStart = 2;
        int visibleEnd = 2;
        int starsCount = length - visibleStart - visibleStart;

        String stars = "*".repeat(Math.max(0, starsCount));
        return document.substring(0, visibleStart) + stars + document.substring(length - visibleEnd);
    }

}