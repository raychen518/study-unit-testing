package xxx.yyy.zzz.b;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xxx.yyy.zzz.a.Parent;

public class Child extends Parent {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    protected void doSomething(Object object) {
        LOGGER.info("doSomething(Object): BEGIN");

        // Invoke a protected superclass method.
        super.doSomething(object);

        // Invoke another protected superclass method.
        Object someObject = doSomethingWithReturn("abc", 123, true);
        LOGGER.info("doSomething(Object): someObject: " + someObject);

        LOGGER.info("doSomething(Object): END");
    }

}
