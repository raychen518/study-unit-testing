package org.raychens.unittesting.mockingmethods.case001.privatemethod;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.spy;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(PowerMockRunner.class)
// Put the class under test in the list of the classes preparing for test.
@PrepareForTest(SomeObject.class)
public class SomeObjectTest {

    @Test
    public void test_doSomething() throws Exception {
        // Use the PowerMockito.spy(...) method instead of the Mockito.spy(...)
        // method here.
        SomeObject someObject = spy(new SomeObject());

        String string = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("string: " + string);

        String resultFromPrivateMethod = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("resultFromPrivateMethod: " + resultFromPrivateMethod);
        // Use the PowerMockito.doReturn(...) method instead of the
        // Mockito.doReturn(...) method here.
        doReturn(resultFromPrivateMethod).when(someObject, "doSomethingPrivately", string);

        String result = someObject.doSomething(string);

        assertEquals(resultFromPrivateMethod + "[doSomething]" + string.toLowerCase(), result);
    }

    // @Test
    public void test_doSomething_withoutMocking() {
        SomeObject someObject = new SomeObject();

        String string = RandomStringUtils.randomAlphanumeric(5);
        System.out.println("string: " + string);

        someObject.doSomething(string);
    }

}
