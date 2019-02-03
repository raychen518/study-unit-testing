package org.raychens.unittesting.mockito.stubbingrules;

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

/**
 * <pre>
 * This test class tests the following stubbing rules.
 * - Stubbing Can Be Overridden
 * - Stubbed Method Invocation Always Returns the Stubbed Value
 * - Last Stubbing Is More Important
 * </pre>
 */
@FixMethodOrder(NAME_ASCENDING)
public class SomeObjectTest {

    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Constant: Text - ABC
     */
    private static final String TEXT_ABC = "abc";

    /**
     * Constant: Text - DEF
     */
    private static final String TEXT_DEF = "def";

    /**
     * Constant: Text - GHI
     */
    private static final String TEXT_GHI = "ghi";

    @Spy
    SomeObject someObject = new SomeObject();

    @Before
    public void setUp() {
        initMocks(this);
        doReturn(TEXT_ABC).when(someObject).doSomething();
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
     * <pre>
     * This test method tests the stubbing rule - Stubbing Can Be Overridden.
     *
     * A common stubbing can be done in the @Before method as a test fixture for some test methods
     * and one test method can override that common stubbing when necessary.
     * </pre>
     */
    @Test
    public void test_101_stubbingCanBeOverridden() {
        doReturn(TEXT_DEF).when(someObject).doSomething();

        LOGGER.info(someObject.doSomething());
    }

    /**
     * <pre>
     * This test method tests the stubbing rule - Stubbed Method Invocation Always Returns the Stubbed Value.
     *
     * Once stubbed, a method invocation always returns the stubbed value unless the stubbing is changed.
     * </pre>
     */
    @Test
    public void test_102_stubbedMethodInvocationAlwaysReturnsTheStubbedValue() {
        LOGGER.info(someObject.doSomething());
        LOGGER.info(someObject.doSomething());
        LOGGER.info(someObject.doSomething());
    }

    /**
     * <pre>
     * This test method tests the stubbing rule - Last Stubbing Is More Important.
     *
     * For a method invocation, it is always the last stubbing that takes effect.
     * </pre>
     */
    @Test
    public void test_103_lastStubbingIsMoreImportant() {
        LOGGER.info(someObject.doSomething());

        doReturn(TEXT_DEF).when(someObject).doSomething();
        LOGGER.info(someObject.doSomething());

        doReturn(TEXT_GHI).when(someObject).doSomething();
        LOGGER.info(someObject.doSomething());
        LOGGER.info(someObject.doSomething());
        LOGGER.info(someObject.doSomething());
    }

}
