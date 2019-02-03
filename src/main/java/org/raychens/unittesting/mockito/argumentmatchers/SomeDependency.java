package org.raychens.unittesting.mockito.argumentmatchers;

import static org.raychens.unittesting.commons.MethodLogMessage.methodBegin;
import static org.raychens.unittesting.commons.MethodLogMessage.methodEnd;
import static org.raychens.unittesting.commons.MethodLogMessage.methodIntermediate;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SomeDependency {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String TEXT_BRACKET_LEFT = "[";
    private static final String TEXT_BRACKET_RIGHT = "]";
    private static final String TEXT_COLON = ":";
    private static final String TEXT_RESULT = "result";
    private static final String TEXT_VERTICAL_BAR = "|";

    private static String getResultPrefix() {
        return new StringBuilder().append(TEXT_BRACKET_LEFT).append(SomeDependency.class.getSimpleName())
                .append(TEXT_BRACKET_RIGHT).toString();
    }

    public String doSomething(boolean bool) {
        String methodName = "doSomething(boolean)";
        LOGGER.info(methodBegin(methodName));

        String result = getResultPrefix() + bool;
        LOGGER.info(methodIntermediate(methodName, TEXT_RESULT, result));

        LOGGER.info(methodEnd(methodName));
        return result;
    }

    public String doSomething(int integer) {
        String methodName = "doSomething(int)";
        LOGGER.info(methodBegin(methodName));

        String result = getResultPrefix() + integer;
        LOGGER.info(methodIntermediate(methodName, TEXT_RESULT, result));

        LOGGER.info(methodEnd(methodName));
        return result;
    }

    public String doSomething(List<Object> list) {
        String methodName = "doSomething(List<Object>)";
        LOGGER.info(methodBegin(methodName));

        StringBuilder resultBuilder = new StringBuilder(getResultPrefix());
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                resultBuilder.append(TEXT_VERTICAL_BAR);
            }
            resultBuilder.append(list.get(i));
        }
        LOGGER.info(methodIntermediate(methodName, TEXT_RESULT, resultBuilder.toString()));

        LOGGER.info(methodEnd(methodName));
        return resultBuilder.toString();
    }

    public String doSomething(Map<String, Object> map) {
        String methodName = "doSomething(Map<String, Object>)";
        LOGGER.info(methodBegin(methodName));

        StringBuilder resultBuilder = new StringBuilder(getResultPrefix());
        int mapEntryCounter = 0;
        for (Entry<String, Object> mapEntry : map.entrySet()) {
            if (mapEntryCounter != 0) {
                resultBuilder.append(TEXT_VERTICAL_BAR);
            }
            resultBuilder.append(mapEntry.getKey()).append(TEXT_COLON).append(mapEntry.getValue());
            mapEntryCounter++;
        }
        LOGGER.info(methodIntermediate(methodName, TEXT_RESULT, resultBuilder.toString()));

        LOGGER.info(methodEnd(methodName));
        return resultBuilder.toString();
    }

    public String doSomething(Object object) {
        String methodName = "doSomething(Object)";
        LOGGER.info(methodBegin(methodName));

        String result = getResultPrefix() + object;
        LOGGER.info(methodIntermediate(methodName, TEXT_RESULT, result));

        LOGGER.info(methodEnd(methodName));
        return result;
    }

    public String doSomething(Object... vararg) {
        String methodName = "doSomething(Object...)";
        LOGGER.info(methodBegin(methodName));

        StringBuilder resultBuilder = new StringBuilder(getResultPrefix());
        for (int i = 0; i < vararg.length; i++) {
            if (i != 0) {
                resultBuilder.append(TEXT_VERTICAL_BAR);
            }
            resultBuilder.append(vararg[i]);
        }
        LOGGER.info(methodIntermediate(methodName, TEXT_RESULT, resultBuilder.toString()));

        LOGGER.info(methodEnd(methodName));
        return resultBuilder.toString();
    }

    public String doSomething(String string) {
        String methodName = "doSomething(String)";
        LOGGER.info(methodBegin(methodName));

        String result = getResultPrefix() + string;
        LOGGER.info(methodIntermediate(methodName, TEXT_RESULT, result));

        LOGGER.info(methodEnd(methodName));
        return result;
    }

    public String doSomething(String string, int integer, boolean bool) {
        String methodName = "doSomething(String, int, boolean)";
        LOGGER.info(methodBegin(methodName));

        String result = new StringBuilder(getResultPrefix()).append(string).append(TEXT_VERTICAL_BAR).append(integer)
                .append(TEXT_VERTICAL_BAR).append(bool).toString();
        LOGGER.info(methodIntermediate(methodName, TEXT_RESULT, result));

        LOGGER.info(methodEnd(methodName));
        return result;
    }

    public String doSomething(Type type) {
        String methodName = "doSomething(Type)";
        LOGGER.info(methodBegin(methodName));

        String result = getResultPrefix() + type;
        LOGGER.info(methodIntermediate(methodName, TEXT_RESULT, result));

        LOGGER.info(methodEnd(methodName));
        return result;
    }

    public String doSomething(TypeA typeA) {
        String methodName = "doSomething(TypeA)";
        LOGGER.info(methodBegin(methodName));

        String result = getResultPrefix() + typeA;
        LOGGER.info(methodIntermediate(methodName, TEXT_RESULT, result));

        LOGGER.info(methodEnd(methodName));
        return result;
    }

    public String doSomething(TypeB typeB) {
        String methodName = "doSomething(TypeB)";
        LOGGER.info(methodBegin(methodName));

        String result = getResultPrefix() + typeB;
        LOGGER.info(methodIntermediate(methodName, TEXT_RESULT, result));

        LOGGER.info(methodEnd(methodName));
        return result;
    }

    public String doSomething(TypeC typeC) {
        String methodName = "doSomething(TypeC)";
        LOGGER.info(methodBegin(methodName));

        String result = getResultPrefix() + typeC;
        LOGGER.info(methodIntermediate(methodName, TEXT_RESULT, result));

        LOGGER.info(methodEnd(methodName));
        return result;
    }

}
