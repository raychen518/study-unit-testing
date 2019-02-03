package org.raychens.unittesting.mockito.stubbingrules;

import static org.raychens.unittesting.commons.DataGenerator.generateString;
import static org.raychens.unittesting.commons.MethodLogMessage.methodBegin;
import static org.raychens.unittesting.commons.MethodLogMessage.methodEnd;
import static org.raychens.unittesting.commons.MethodLogMessage.methodProcessing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SomeObject {

    private static final Logger LOGGER = LogManager.getLogger();

    public String doSomething() {
        String methodName = "doSomething()";
        LOGGER.info(methodBegin(methodName));

        LOGGER.info(methodProcessing(methodName));

        LOGGER.info(methodEnd(methodName));
        return generateString();
    }

}
