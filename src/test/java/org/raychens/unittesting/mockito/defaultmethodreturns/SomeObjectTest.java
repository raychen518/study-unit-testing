package org.raychens.unittesting.mockito.defaultmethodreturns;

import static org.mockito.Mockito.RETURNS_MOCKS;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;

import org.apache.commons.lang3.StringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SomeObjectTest {

    private static void displayMethodReturns(SomeObject someObject, String title) {
        displayMethodReturns(someObject, title, true);
    }

    private static void displayMethodReturns(SomeObject someObject, String title, boolean addingLeadingBlankLine) {
        if (addingLeadingBlankLine) {
            System.out.println();
        }

        System.out.println(title);
        System.out.println(StringUtils.repeat("=", 80));

        System.out.println("someObject.getByteValue()\t\t: " + someObject.getByteValue());
        System.out.println("someObject.getShortValue()\t\t: " + someObject.getShortValue());
        System.out.println("someObject.getIntValue()\t\t: " + someObject.getIntValue());
        System.out.println("someObject.getLongValue()\t\t: " + someObject.getLongValue());
        System.out.println("someObject.getFloatValue()\t\t: " + someObject.getFloatValue());
        System.out.println("someObject.getDoubleValue()\t\t: " + someObject.getDoubleValue());
        System.out.println("someObject.getBooleanValue()\t\t: " + someObject.getBooleanValue());
        System.out.println("someObject.getCharValue()\t\t: " + someObject.getCharValue());

        System.out.println();
        System.out.println("someObject.getIntegerWrapper()\t\t: " + someObject.getIntegerWrapper());
        System.out.println("someObject.getDoubleWrapper()\t\t: " + someObject.getDoubleWrapper());
        System.out.println("someObject.getBooleanWrapper()\t\t: " + someObject.getBooleanWrapper());
        System.out.println("someObject.getCharacterWrapper()\t: " + someObject.getCharacterWrapper());
        System.out.println();

        System.out.println("someObject.getString()\t\t\t: " + someObject.getString()
                + getMessageForEmptyString(someObject.getString()));
        System.out.println("someObject.getObject()\t\t\t: " + someObject.getObject());

        System.out.println();
        System.out.println("someObject.getArray()\t\t\t: " + someObject.getArray()
                + getMessageForEmptyArray(someObject.getArray()));
        System.out.println("someObject.getList()\t\t\t: " + someObject.getList());
        System.out.println("someObject.getMap()\t\t\t: " + someObject.getMap());

        System.out.println(StringUtils.repeat("=", 80));
    }

    private static String getMessageForEmptyArray(Object[] array) {
        String message = StringUtils.EMPTY;

        if (array != null && array.length == 0) {
            message = " <Empty: true>";
        }

        return message;
    }

    private static String getMessageForEmptyString(String string) {
        String message = StringUtils.EMPTY;

        if (string != null && string.isEmpty()) {
            message = "<Empty: true>";
        }

        return message;
    }

    @Test
    public void displayMethodReturnsOfMockObjectCreatedUsingAnswer_1_RETURNS_DEFAULTS() {
        // Answer: Mockito.RETURNS_DEFAULTS (default)
        // Policy: ReturnsEmptyValues
        SomeObject someObject = mock(SomeObject.class);
        String title = "1. Mock Object Created Using Answer - RETURNS_DEFAULTS (default)";
        displayMethodReturns(someObject, title, false);
    }

    @Test
    public void displayMethodReturnsOfMockObjectCreatedUsingAnswer_2_RETURNS_SMART_NULLS() {
        // Answer: Mockito.RETURNS_SMART_NULLS
        // Policy: ReturnsMoreEmptyValues
        // Method Returns Different from RETURNS_DEFAULTS
        // - String-returning methods return empty strings instead of null.
        // - Object-returning methods return SmartNull instead of null.
        // - Array-returning methods return empty arrays instead of null.
        SomeObject someObject = mock(SomeObject.class, RETURNS_SMART_NULLS);
        String title = "2. Mock Object Created Using Answer - RETURNS_SMART_NULLS";
        displayMethodReturns(someObject, title);
    }

    @Test
    public void displayMethodReturnsOfMockObjectCreatedUsingAnswer_3_RETURNS_MOCKS() {
        // Answer: Mockito.RETURNS_MOCKS
        // Policy: ReturnsMoreEmptyValues
        // Method Returns Different from RETURNS_SMART_NULLS
        // - Object-returning methods return a mock object instead of SmartNull.
        SomeObject someObject = mock(SomeObject.class, RETURNS_MOCKS);
        String title = "3. Mock Object Created Using Answer - RETURNS_MOCKS";
        displayMethodReturns(someObject, title);
    }

}
