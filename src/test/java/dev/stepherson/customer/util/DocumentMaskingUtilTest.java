package dev.stepherson.customer.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DocumentMaskingUtilTest {
    @Test
    public void testMaskDocument() {
        assertEquals("53*******83", DocumentMaskingUtil.maskDocument("53395487083"));
        assertEquals("31**********83", DocumentMaskingUtil.maskDocument("31273468000183"));
        assertEquals("***********", DocumentMaskingUtil.maskDocument("12"));
    }
}
