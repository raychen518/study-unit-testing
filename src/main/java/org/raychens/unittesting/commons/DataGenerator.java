package org.raychens.unittesting.commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class DataGenerator {

    private static final int DEFAULT_GENERATING_ARRAY_ELEMENT_COUNT = 3;
    private static final int DEFAULT_GENERATING_INTEGER_MAX = 100000;
    private static final int DEFAULT_GENERATING_INTEGER_MIN = 10000;
    private static final int DEFAULT_GENERATING_LIST_ELEMENT_COUNT = 3;
    private static final int DEFAULT_GENERATING_MAP_ENTRY_COUNT = 3;
    private static final int DEFAULT_GENERATING_STRING_LENGTH = 5;

    public static Object[] generateArray() {
        Object[] array = new Object[DEFAULT_GENERATING_ARRAY_ELEMENT_COUNT];

        for (int i = 0; i < array.length; i++) {
            array[i] = generateObject();
        }

        return array;
    }

    public static boolean generateBoolean() {
        return RandomUtils.nextBoolean();
    }

    public static int generateInteger() {
        return RandomUtils.nextInt(DEFAULT_GENERATING_INTEGER_MIN, DEFAULT_GENERATING_INTEGER_MAX);
    }

    public static List<Object> generateList() {
        List<Object> list = new ArrayList<>();

        for (int i = 0; i < DEFAULT_GENERATING_LIST_ELEMENT_COUNT; i++) {
            list.add(generateObject());
        }

        return list;
    }

    public static Map<String, Object> generateMap() {
        Map<String, Object> map = new HashMap<>();

        for (int i = 0; i < DEFAULT_GENERATING_MAP_ENTRY_COUNT; i++) {
            map.put(generateString(), generateObject());
        }

        return map;
    }

    public static Object generateObject() {
        return new Object();
    }

    public static <T> T generateObject(Class<T> type) {
        T result;

        try {
            result = type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            result = null;
        }

        return result;
    }

    public static String generateString() {
        return RandomStringUtils.randomAlphanumeric(DEFAULT_GENERATING_STRING_LENGTH);
    }

    public static Object[] generateVararg() {
        return generateArray();
    }

    private DataGenerator() {
        // Utility classes, which are collections of static members, are not
        // meant to be instantiated.
        // As a utility class, this class follows the above rule by making its
        // implicit public constructor private.
    }

}
