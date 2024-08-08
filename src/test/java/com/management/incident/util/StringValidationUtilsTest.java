package com.management.incident.util;

import org.junit.jupiter.api.Assertions;

public class StringValidationUtilsTest {


    @org.junit.jupiter.api.Test
    public void testStringToPageNumberWithValidNumber() {
        // Arrange
        String pageString = "5";

        // Act
        Integer pageNumber = StringValidationUtils.stringToPageNumber(pageString);

        // Assert
        Assertions.assertEquals( 5, pageNumber.intValue());
    }


    @org.junit.jupiter.api.Test
    public void testStringToPageNumberWithNegativeNumber() {
        // Arrange
        String pageString = "-1";

        // Act
        Integer pageNumber = StringValidationUtils.stringToPageNumber(pageString);

        // Assert
        Assertions.assertEquals( 0, pageNumber.intValue());
    }


    @org.junit.jupiter.api.Test
    public void testStringToPageNumberWithZero() {
        // Arrange
        String pageString = "0";

        // Act
        Integer pageNumber = StringValidationUtils.stringToPageNumber(pageString);

        // Assert
        Assertions.assertEquals( 0, pageNumber.intValue());
    }


    @org.junit.jupiter.api.Test
    public void testStringToPageNumberWithNullString() {
        // Arrange
        String pageString = null;

        // Act
        Integer pageNumber = StringValidationUtils.stringToPageNumber(pageString);

        // Assert
        Assertions.assertEquals( 0, pageNumber.intValue());
    }


    @org.junit.jupiter.api.Test
    public void testStringToPageNumberWithNonNumericString() {
        // Arrange
        String pageString = "abc";

        // Act
        Integer pageNumber = StringValidationUtils.stringToPageNumber(pageString);

        // Assert
        Assertions.assertEquals( 0, pageNumber.intValue());
    }


    @org.junit.jupiter.api.Test
    public void testStringToPageNumberWithEmptyString() {
        // Arrange
        String pageString = "";

        // Act
        Integer pageNumber = StringValidationUtils.stringToPageNumber(pageString);

        // Assert
        Assertions.assertEquals( 0, pageNumber.intValue());
    }


    @org.junit.jupiter.api.Test
    public void testStringToPageNumberWithSpaces() {
        // Arrange
        String pageString = "   ";

        // Act
        Integer pageNumber = StringValidationUtils.stringToPageNumber(pageString);

        // Assert
        Assertions.assertEquals( 0, pageNumber.intValue());
    }


    @org.junit.jupiter.api.Test
    public void testStringToPageNumberWithLargeNumber() {
        // Arrange
        String pageString = "2147483647"; // Integer.MAX_VALUE

        // Act
        Integer pageNumber = StringValidationUtils.stringToPageNumber(pageString);

        // Assert
        Assertions.assertEquals( Integer.MAX_VALUE, pageNumber.intValue());
    }
}
