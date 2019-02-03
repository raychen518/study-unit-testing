package org.raychens.unittesting.mockito.stubbingbasics;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.mockito.Spy;

@FixMethodOrder(NAME_ASCENDING)
public class SomeObjectTest {

    private static final Logger LOGGER = LogManager.getLogger();

    @Spy
    SomeObject someObject = new SomeObject();

    @Before
    public void setUp() {
        initMocks(this);
        doReturn("abc").when(someObject).doSomething();
    }

    @Test
    public void test_000() {
        doCallRealMethod().when(someObject).doSomething();

        LOGGER.info(someObject.doSomething());
    }

    @Test
    public void test_001() {
        LOGGER.info(someObject.doSomething());
    }

    /**
     * <p>
     * This test method tests the rule - Stubbing Can Be Overridden.
     * </p>
     *
     * <p>
     * A common stubbing can be done in the @Before method as a test fixture for
     * some test methods and one test method can override that common stubbing
     * when necessary.
     * </p>
     */
    @Test
    public void test_101_stubbingCanBeOverridden() {
        doReturn("def").when(someObject).doSomething();

        LOGGER.info(someObject.doSomething());
    }

    /**
     * <p>
     * This test method tests the rule - Stubbed Method Invocation Always
     * Returns the Stubbed Value.
     * </p>
     *
     * <p>
     * Once stubbed, invoking the method always returns the stubbed value before
     * the stubbing is changed.
     * </p>
     */
    @Test
    public void test_102_stubbedMethodInvocationAlwaysReturnStubbedValue() {
        LOGGER.info(someObject.doSomething());
        LOGGER.info(someObject.doSomething());
        LOGGER.info(someObject.doSomething());
    }

    /**
     * <p>
     * This test method tests the rule - Last Stubbing Is More Important.
     * </p>
     *
     * <p>
     * It is always the last stubbing that takes effect for a method invocation.
     * </p>
     */
    @Test
    public void test_103_lastStubbingIsMoreImportant() {
        LOGGER.info(someObject.doSomething());

        doReturn("def").when(someObject).doSomething();
        LOGGER.info(someObject.doSomething());

        doReturn("ghi").when(someObject).doSomething();
        LOGGER.info(someObject.doSomething());

        doReturn("jkl").when(someObject).doSomething();
        LOGGER.info(someObject.doSomething());
        LOGGER.info(someObject.doSomething());
        LOGGER.info(someObject.doSomething());
    }

}
