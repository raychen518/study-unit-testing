package org.raychens.unittesting.commons.logging;

import org.apache.commons.lang3.StringUtils;

public class MethodLogMessage {

    private static final String METHOD_PARAMETER_DELIMITER = ", ";
    private static final String TEXT_BEGIN = "BEGIN";
    private static final String TEXT_COLON = ":";
    private static final String TEXT_END = "END";

    public static String methodBegin(String methodName) {
        return new StringBuilder(methodName).append(TEXT_COLON).append(StringUtils.SPACE).append(TEXT_BEGIN).toString();
    }

    public static String methodEnd(String methodName) {
        return new StringBuilder(methodName).append(TEXT_COLON).append(StringUtils.SPACE).append(TEXT_END).toString();
    }

    public static String methodIntermediate(String methodName, String methodIntermediateName,
            String methodIntermediateValue) {
        return new StringBuilder(methodName).append(TEXT_COLON).append(StringUtils.SPACE).append(methodIntermediateName)
                .append(TEXT_COLON).append(StringUtils.SPACE).append(methodIntermediateValue).toString();
    }

    public static String methodParameterList(Object... methodParameters) {
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < methodParameters.length; i++) {
            if (i != 0) {
                resultBuilder.append(METHOD_PARAMETER_DELIMITER);
            }
            resultBuilder.append(methodParameters[i]);
        }

        return resultBuilder.toString();
    }

    private MethodLogMessage() {
        // Utility classes, which are collections of static members, are not
        // meant to be instantiated.
        // As a utility class, this class follows the above rule by making its
        // implicit public constructor private.
    }

}
