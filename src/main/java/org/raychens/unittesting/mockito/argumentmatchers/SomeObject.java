package org.raychens.unittesting.mockito.argumentmatchers;

import static org.raychens.unittesting.commons.DataGenerator.generateBoolean;
import static org.raychens.unittesting.commons.DataGenerator.generateInteger;
import static org.raychens.unittesting.commons.DataGenerator.generateList;
import static org.raychens.unittesting.commons.DataGenerator.generateMap;
import static org.raychens.unittesting.commons.DataGenerator.generateObject;
import static org.raychens.unittesting.commons.DataGenerator.generateString;
import static org.raychens.unittesting.commons.DataGenerator.generateVararg;
import static org.raychens.unittesting.commons.logging.MethodLogMessage.methodBegin;
import static org.raychens.unittesting.commons.logging.MethodLogMessage.methodEnd;
import static org.raychens.unittesting.commons.logging.MethodLogMessage.methodIntermediate;
import static org.raychens.unittesting.commons.logging.MethodLogMessage.methodParameterList;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SomeObject {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String METHOD_INVOCATION_PREFIX = "someDependency.doSomething(";
    private static final String METHOD_INVOCATION_SUFFIX = ")";

    private static final int PROCESS_TIMES = 3;

    private static String methodInvocation(Object methodParameterList) {
        return new StringBuilder().append(METHOD_INVOCATION_PREFIX).append(methodParameterList)
                .append(METHOD_INVOCATION_SUFFIX).toString();
    }

    private SomeDependency someDependency;

    public void doSomething01() {
        String methodName = "doSomething01()";
        LOGGER.info(methodBegin(methodName));

        String string = generateString();
        LOGGER.info(methodIntermediate(methodName, methodInvocation(string), someDependency.doSomething(string)));

        int integer = generateInteger();
        LOGGER.info(methodIntermediate(methodName, methodInvocation(integer), someDependency.doSomething(integer)));

        boolean bool = generateBoolean();
        LOGGER.info(methodIntermediate(methodName, methodInvocation(bool), someDependency.doSomething(bool)));

        Object object = generateObject();
        LOGGER.info(methodIntermediate(methodName, methodInvocation(object), someDependency.doSomething(object)));

        Type type = generateObject(Type.class);
        LOGGER.info(methodIntermediate(methodName, methodInvocation(type), someDependency.doSomething(type)));

        List<Object> list = generateList();
        LOGGER.info(methodIntermediate(methodName, methodInvocation(list), someDependency.doSomething(list)));

        Map<String, Object> map = generateMap();
        LOGGER.info(methodIntermediate(methodName, methodInvocation(map), someDependency.doSomething(map)));

        Object[] vararg = generateVararg();
        LOGGER.info(methodIntermediate(methodName, methodInvocation(methodParameterList(vararg)),
                someDependency.doSomething(vararg)));

        LOGGER.info(methodEnd(methodName));
    }

    public void doSomething02() {
        String methodName = "doSomething02()";
        LOGGER.info(methodBegin(methodName));

        String string;
        int integer;
        for (int i = 0; i < PROCESS_TIMES; i++) {
            string = generateString();
            integer = generateInteger();
            LOGGER.info(methodIntermediate(methodName, methodInvocation(methodParameterList(string, integer, true)),
                    someDependency.doSomething(string, integer, true)));
        }

        LOGGER.info(methodEnd(methodName));
    }

    public void doSomethingUsingBoolean() {
        String methodName = "doSomethingUsingBoolean()";
        LOGGER.info(methodBegin(methodName));

        for (int i = 0; i < PROCESS_TIMES; i++) {
            boolean bool = generateBoolean();
            LOGGER.info(methodIntermediate(methodName, methodInvocation(bool), someDependency.doSomething(bool)));
        }

        LOGGER.info(methodEnd(methodName));
    }

    public void doSomethingUsingInteger() {
        String methodName = "doSomethingUsingInteger()";
        LOGGER.info(methodBegin(methodName));

        for (int i = 0; i < PROCESS_TIMES; i++) {
            int integer = generateInteger();
            LOGGER.info(methodIntermediate(methodName, methodInvocation(integer), someDependency.doSomething(integer)));
        }

        LOGGER.info(methodEnd(methodName));
    }

    public void doSomethingUsingList() {
        String methodName = "doSomethingUsingList()";
        LOGGER.info(methodBegin(methodName));

        List<Object> list = generateList();
        LOGGER.info(methodIntermediate(methodName, methodInvocation(list), someDependency.doSomething(list)));

        LOGGER.info(methodEnd(methodName));
    }

    public void doSomethingUsingMap() {
        String methodName = "doSomethingUsingMap()";
        LOGGER.info(methodBegin(methodName));

        Map<String, Object> map = generateMap();
        LOGGER.info(methodIntermediate(methodName, methodInvocation(map), someDependency.doSomething(map)));

        LOGGER.info(methodEnd(methodName));
    }

    public void doSomethingUsingObject() {
        String methodName = "doSomethingUsingObject()";
        LOGGER.info(methodBegin(methodName));

        for (int i = 0; i < PROCESS_TIMES; i++) {
            Object object = generateObject();
            LOGGER.info(methodIntermediate(methodName, methodInvocation(object), someDependency.doSomething(object)));
        }

        LOGGER.info(methodEnd(methodName));
    }

    public void doSomethingUsingString() {
        String methodName = "doSomethingUsingString()";
        LOGGER.info(methodBegin(methodName));

        for (int i = 0; i < PROCESS_TIMES; i++) {
            String string = generateString();
            LOGGER.info(methodIntermediate(methodName, methodInvocation(string), someDependency.doSomething(string)));
        }

        LOGGER.info(methodEnd(methodName));
    }

    public void doSomethingUsingType() {
        String methodName = "doSomethingUsingType()";
        LOGGER.info(methodBegin(methodName));

        TypeA typeA = new TypeA();
        LOGGER.info(methodIntermediate(methodName, methodInvocation(typeA), someDependency.doSomething(typeA)));

        TypeB typeB = new TypeB();
        LOGGER.info(methodIntermediate(methodName, methodInvocation(typeB), someDependency.doSomething(typeB)));

        TypeC typeC = new TypeC();
        LOGGER.info(methodIntermediate(methodName, methodInvocation(typeC), someDependency.doSomething(typeC)));

        LOGGER.info(methodEnd(methodName));
    }

    public void doSomethingUsingVararg() {
        String methodName = "doSomethingUsingVararg()";
        LOGGER.info(methodBegin(methodName));

        Object[] vararg = generateVararg();
        LOGGER.info(methodIntermediate(methodName, methodInvocation(methodParameterList(vararg)),
                someDependency.doSomething(vararg)));

        LOGGER.info(methodEnd(methodName));
    }

    public SomeDependency getSomeDependency() {
        return someDependency;
    }

    public void setSomeDependency(SomeDependency someDependency) {
        this.someDependency = someDependency;
    }

}
