package org.raychens.unittesting.commons.logging;

import org.apache.commons.lang3.StringUtils;

public class MethodLogMessage {

    /**
     * Constant - The Delimiter for Method Parameters in a List
     */
    private static final String METHOD_PARAMETER_DELIMITER = ", ";

    /**
     * Text Constant - BEGIN
     */
    private static final String TEXT_BEGIN = "BEGIN";

    /**
     * Text Constant - Colon (:)
     */
    private static final String TEXT_COLON = ":";

    /**
     * Text Constant - END
     */
    private static final String TEXT_END = "END";

    /**
     * Returns the Method Begin log message for the specified method.
     *
     * @param methodName
     *            Name of the specified method.
     * @return the Method Begin log message for the specified method.
     */
    public static String methodBegin(String methodName) {
        return new StringBuilder(methodName).append(TEXT_COLON).append(StringUtils.SPACE).append(TEXT_BEGIN).toString();
    }

    /**
     * Returns the Method End log message for the specified method.
     *
     * @param methodName
     *            Name of the specified method.
     * @return the Method End log message for the specified method.
     */
    public static String methodEnd(String methodName) {
        return new StringBuilder(methodName).append(TEXT_COLON).append(StringUtils.SPACE).append(TEXT_END).toString();
    }

    /**
     * Returns the Method Intermediate log message for the specified method.
     *
     * @param methodName
     *            Name of the specified method.
     * @param methodIntermediateName
     *            Name of the method intermediate.
     * @param methodIntermediateValue
     *            Value of the method intermediate.
     * @return the Method Intermediate log message for the specified method.
     */
    public static String methodIntermediate(String methodName, String methodIntermediateName,
            String methodIntermediateValue) {
        return new StringBuilder(methodName).append(TEXT_COLON).append(StringUtils.SPACE).append(methodIntermediateName)
                .append(TEXT_COLON).append(StringUtils.SPACE).append(methodIntermediateValue).toString();
    }

    /**
     * Returns the Method Parameter List log message for the specified method
     * parameters.
     *
     * @param methodParameters
     *            The specified method parameters.
     * @return the Method Parameter List log message for the specified method
     *         parameters.
     */
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

    /**
     * Constructs an instance.
     */
    private MethodLogMessage() {
        // Utility classes, which are collections of static members, are not
        // meant to be instantiated.
        // As a utility class, this class follows the above rule by making its
        // implicit public constructor private.
    }

}
