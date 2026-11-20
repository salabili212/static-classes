package com.plurasight;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameFormatterTest {

    @Test
    public void format() {
        String actual = NameFormatter.format("Mel", "Johnson");

        assertEquals("Johnson, Mel", actual);
    }

    @Test
    public void testFormat() {
        String actual = NameFormatter.format(null, "Mel", null, "Johnson", "");

        assertEquals("Johnson, Mel", actual);
    }

    @Test
    public void testFormat1() {
        String actual = NameFormatter.format("Dr. Mel B Johnson, PhD");

        assertEquals("Johnson, Dr. Mel B, PhD", actual);
    }

    @Test
    public void formatFullName() {
        String actual = NameFormatter.format("Dr. Mel Johnson, PhD");

        assertEquals("Johnson, Dr. Mel, PhD", actual);
    }

    @Test
    public void formatOtherCases() {
        String actual = NameFormatter.format("Mel Johnson");

        assertEquals("Johnson, Mel", actual);
    }

    @Test
    public void formatPlacesPrefixBeforeFirstName() {
        String actual = NameFormatter.format("Dr.", "Mel", "B", "Johnson", "PhD");

        assertEquals("Johnson, Dr. Mel B, PhD", actual);
    }
}