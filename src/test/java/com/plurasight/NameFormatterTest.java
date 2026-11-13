package com.plurasight;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class NameFormatterTest {

    @Test
    public void format() {

        String actual  = NameFormatter.format("Johnson", "Mel");
        Assertions.assertEquals("Johnson, Mel",actual );

    }

    @Test
    public void testFormat() {
        String actual = NameFormatter.format(null, "Mel", null, "Johnson", "");
        Assertions.assertEquals("Johnson, Mel",actual.trim());
    }

    @Test
    public void testFormat1() {
        String actual = NameFormatter.format("Dr. Mel B Johnson, PhD");
        Assertions.assertEquals("Johnson, Dr. Mel B, PhD",actual.trim());
    }

    @Test
    public void formatFullName() {
        String actual = NameFormatter.format("Dr. Mel Johnson, PhD");
        Assertions.assertEquals("Johnson, Dr. Mel, PhD",actual.trim());
    }

    @Test
    public void formatOtherCases() {
        String actual = NameFormatter.format("Mel Johnson");
        Assertions.assertEquals("Johnson, Mel",actual.trim());
    };
}