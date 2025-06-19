package dev.stepherson.customer.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DocumentTest {

    @Test
    public void testValidCPF() {
        assertFalse(Document.isValidCPFOrCNPJ("123.456.789-01"));
        assertFalse(Document.isValidCPFOrCNPJ("111.111.111.11"));
        assertTrue(Document.isValidCPFOrCNPJ("465.618.660-02"));
    }

    @Test
    public void testValidCNPJ() {
        assertTrue(Document.isValidCPFOrCNPJ("31.926.784/0001-07"));
        assertFalse(Document.isValidCPFOrCNPJ("31.273.468/0001-00"));
    }
}
