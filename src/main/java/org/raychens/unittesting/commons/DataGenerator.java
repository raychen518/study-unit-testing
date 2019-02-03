package org.raychens.unittesting.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class DataGenerator {

    /**
     * Constant - The Default Element Count of the Generating Array
     */
    private static final int DEFAULT_GENERATING_ARRAY_ELEMENT_COUNT = 3;

    /**
     * Constant - The Default Maximum of the Generating Integer
     */
    private static final int DEFAULT_GENERATING_INTEGER_MAX = 100000;

    /**
     * Constant - The Default Minimum of the Generating Integer
     */
    private static final int DEFAULT_GENERATING_INTEGER_MIN = 10000;

    /**
     * Constant - The Default Element Count of the Generating List
     */
    private static final int DEFAULT_GENERATING_LIST_ELEMENT_COUNT = 3;

    /**
     * Constant - The Default Entry Count of the Generating Map
     */
    private static final int DEFAULT_GENERATING_MAP_ENTRY_COUNT = 3;

    /**
     * Constant - The Default Length of the Generating String
     */
    private static final int DEFAULT_GENERATING_STRING_LENGTH = 5;

    /**
     * Generates an array which all elements are random objects.
     *
     * @return an array which all elements are random objects.
     */
    public static Object[] generateArray() {
        Object[] array = new Object[DEFAULT_GENERATING_ARRAY_ELEMENT_COUNT];

        for (int i = 0; i < array.length; i++) {
            array[i] = generateObject();
        }

        return array;
    }

    /**
     * Generates a random boolean.
     *
     * @return a random boolean.
     */
    public static boolean generateBoolean() {
        return RandomUtils.nextBoolean();
    }

    /**
     * Generates a random integer.
     *
     * @return a random integer.
     */
    public static int generateInteger() {
        return RandomUtils.nextInt(DEFAULT_GENERATING_INTEGER_MIN, DEFAULT_GENERATING_INTEGER_MAX);
    }

    /**
     * Generates a list which all elements are random objects.
     *
     * @return a list which all elements are random objects.
     */
    public static List<Object> generateList() {
        List<Object> list = new ArrayList<>();

        for (int i = 0; i < DEFAULT_GENERATING_LIST_ELEMENT_COUNT; i++) {
            list.add(generateObject());
        }

        return list;
    }

    /**
     * Generates a map which all entry keys are strings and all entry values are
     * random objects.
     *
     * @return a map which all entry keys are strings and all entry values are
     *         random objects.
     */
    public static Map<String, Object> generateMap() {
        Map<String, Object> map = new HashMap<>();

        for (int i = 0; i < DEFAULT_GENERATING_MAP_ENTRY_COUNT; i++) {
            map.put(generateString(), generateObject());
        }

        return map;
    }

    /**
     * Generates a random object.
     *
     * @return a random object.
     */
    public static Object generateObject() {
        return new Object();
    }

    /**
     * Generates a random object with the specified type.
     *
     * @param type
     *            Type of the random object to generate.
     * @return a random object with the specified type.
     */
    public static <T> T generateObject(Class<T> type) {
        T result;

        try {
            result = type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            result = null;
        }

        return result;
    }

    /**
     * Generates a random string.
     *
     * @return a random string.
     */
    public static String generateString() {
        return RandomStringUtils.randomAlphanumeric(DEFAULT_GENERATING_STRING_LENGTH);
    }

    /**
     * Generates a random vararg.
     *
     * @return a random vararg.
     */
    public static Object[] generateVararg() {
        return generateArray();
    }

    /**
     * Constructs an instance.
     */
    private DataGenerator() {
        // Utility classes, which are collections of static members, are not
        // meant to be instantiated.
        // As a utility class, this class follows the above rule by making its
        // implicit public constructor private.
    }

}
