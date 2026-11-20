package com.plurasight;

import java.util.regex.Pattern;

public class NameFormatter {
    private NameFormatter(){};



    public static String format(String prefix,
                                String firstName,
                                String middleName,
                                String lastName,
                                String suffix) {
        String result = "";
        if (lastName == null) lastName = "";
        if (firstName == null) firstName = "";
        if (middleName == null) middleName = "";
        if (suffix == null) suffix = "";
        if (prefix == null) prefix = "";

        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("Invalid input Please try to enter the First Name Or Last Name correctly\n");
        }
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("Invalid input Please try to enter the First Name Or Last Name correctly\n");
        }

        result += lastName + ", ";

        if (!prefix.isEmpty()) {
            result += prefix + " ";
        }

        result += firstName;

        if (!middleName.isEmpty()) {
            result += " " + middleName;
        }

        if (!suffix.isEmpty()) {
            result += ", " + suffix;
        }

        return result;
    }

    public static String format(String firstName, String lastName) {
        return format("", firstName, "", lastName, "");
    }

    public static String format(String fullName) {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Enter a full name.");
        }

        return formatOtherCases(fullName.trim());
    }

    public static String formatFullName(String fullName) {
        return format(fullName);
    }

    public static String formatOtherCases(String fullName){
        String[] parts = fullName.split(Pattern.quote(","),2);
        String[] prefixes = {"Mr.", "Mrs.", "Ms.", "Dr."};
        String suffix = "";
        String prefix = "";
        String result = "";
        int size = parts.length;
        if(size == 2) suffix = parts[1].trim();


        String[] names = parts[0].trim().split("\\s+");

        for (String tempPrefix : prefixes) {
            if (names[0].equalsIgnoreCase(tempPrefix)) {
                prefix = names[0];
                break;
            }
        }

        int start = 0;
        if (!prefix.isEmpty()) start = 1;

        // Require at least first and last name after the prefix
        if (names.length - start < 2) {
            throw new IllegalArgumentException("Enter a first and last name.");
        }

        String firstName = names[start];
        String lastName = names[names.length - 1];
        String middleName = "";
        // Words between first and last are the middle name
        for (int i = start + 1; i < names.length - 1; i++) {
            if (!middleName.isEmpty()) middleName += " ";
            middleName += names[i];
        }

        result += lastName + ", ";

        if (!prefix.isEmpty()) {
            result += prefix + " ";
        }

        result = lastName + ", ";

        if (!prefix.isEmpty()) result += prefix + " ";

        result += firstName;

        if (!middleName.isEmpty()) result += " " + middleName;
        if (!suffix.isEmpty()) result += ", " + suffix;

        return result;
    }


}
