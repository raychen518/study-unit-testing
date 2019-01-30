package xxx.yyy.zzz.a;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Parent {

    private static final Logger LOGGER = LogManager.getLogger();

    private Object someObject;

    protected void doSomething(Object object) {
        LOGGER.info("doSomething(Object): BEGIN");

        LOGGER.info("doSomething(Object): Doing Something...");
        // Do something...

        LOGGER.info("doSomething(Object): END");
    }

    protected Object doSomethingWithReturn(String string, int integer, boolean bool) {
        LOGGER.info("doSomethingWithReturn(String, int, boolean): BEGIN");

        LOGGER.info("doSomethingWithReturn(String, int, boolean): Doing Something...");
        // Do something...

        LOGGER.info("doSomethingWithReturn(String, int, boolean): END");
        return someObject;
    }

}
